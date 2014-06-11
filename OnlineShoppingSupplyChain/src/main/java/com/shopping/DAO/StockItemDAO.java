package com.shopping.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.beans.Manufacturer;
import com.shopping.beans.Product;
import com.shopping.beans.StockItem;
import com.shopping.beans.Warehouse;

@Repository
public class StockItemDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(StockItem stockItem)
	{
		Session session = sessionFactory.openSession();
		session.save(stockItem);
		session.close();
	}
	
	@Transactional
	public StockItem findStockItemById(int id)
	{
		Session session = sessionFactory.openSession();
		StockItem stockItem = (StockItem)session.get(StockItem.class, id);
		session.close();
		return stockItem;
	}
	
	public void update(StockItem stockItem)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(stockItem);
		tx.commit();
		session.close();
	}
	
	public void delete(StockItem stockItem)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(stockItem);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public ArrayList<StockItem> findStockItemByWarehouse(Warehouse warehouse)
	{
		Session session = sessionFactory.openSession();
		ArrayList<StockItem> stockItemList = new ArrayList<StockItem>();
		Query query= session.createQuery("from StockItem where warehouse = :warehouse ");
		query.setParameter("warehouse", warehouse);
		if (query.list().size() == 0) {
			session.close();
			return new ArrayList<StockItem>();
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				stockItemList.add((StockItem)query.list().get(i));
			}
		}
		session.close();
		return stockItemList;
	}
	
	
	@Transactional
	public StockItem checkStockItemList(Product product, Warehouse warehouse)
	{
		ArrayList<StockItem> stockItemList = findStockItemByWarehouse(warehouse);
		for(int j=0;j<stockItemList.size();j++)
		{
			System.out.println("1 "+stockItemList.get(j).getProduct().getName());
			if(stockItemList.get(j).getProduct().getId()==product.getId())
			{
				System.out.print("true");
				
				return stockItemList.get(j);
			}
		}
		return null;
	}
	
}
