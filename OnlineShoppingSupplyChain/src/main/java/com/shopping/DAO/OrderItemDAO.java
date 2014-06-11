package com.shopping.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.beans.CustomerOrder;
import com.shopping.beans.Manufacturer;
import com.shopping.beans.OrderItem;
import com.shopping.beans.Person;
import com.shopping.beans.StockItem;
import com.shopping.beans.Warehouse;


@Repository
public class OrderItemDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(OrderItem orderItem)
	{
		Session session = sessionFactory.openSession();
		session.save(orderItem);
		session.close();
	}
	
	@Transactional
	public OrderItem findOrderItemById(int id)
	{
		Session session = sessionFactory.openSession();
		OrderItem orderItem = (OrderItem)session.get(OrderItem.class, id);
		session.close();
		return orderItem;
	}
	
	public void update(OrderItem orderItem)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(orderItem);
		tx.commit();
		session.close();
	}
	
	public void delete(OrderItem orderItem)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(orderItem);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public ArrayList<OrderItem> findOrderItemByOrder(CustomerOrder order)
	{
		Session session = sessionFactory.openSession();
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		Query query= session.createQuery("from OrderItem where customerOrder = :order ");
		query.setParameter("order", order);
		if (query.list().size() == 0) {
			session.close();
			return new ArrayList<OrderItem>();
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				orderItemList.add((OrderItem)query.list().get(i));
			}
		}
		session.close();
		return orderItemList;
	}
	@Transactional
	public ArrayList<OrderItem> findOrderItemsByStatus(String status)
	{
		Session session = sessionFactory.openSession();
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		Query query= session.createQuery("from OrderItem where status = :status ");
		query.setParameter("status", status);
		if (query.list().size() == 0) {
			session.close();
			return new ArrayList<OrderItem>();
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				orderItemList.add((OrderItem)query.list().get(i));
			}
		}
		session.close();
		return orderItemList;
	}
	
	@Transactional
	public ArrayList<OrderItem> findOrderItemsByStatusandManufacturer(String status, Manufacturer manufacturer)
	{
		Session session = sessionFactory.openSession();
		OrderItem orderItem=null;
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		Query query= session.createQuery("from OrderItem where status = :status ");
		query.setParameter("status", status);
		if (query.list().size() == 0) {
			session.close();
			return new ArrayList<OrderItem>();
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				orderItem= (OrderItem)query.list().get(i);
				if(orderItem.getProduct().getManufacturer().getId()==manufacturer.getId())
				{
					System.out.println(orderItem.getId());
					orderItemList.add(orderItem);
				}
			}
		}
		session.close();
		return orderItemList;
	}
	

}
