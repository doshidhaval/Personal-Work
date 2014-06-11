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

@Repository
public class ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Product product)
	{
		Session session = sessionFactory.openSession();
		session.save(product);
		session.close();
	}
	
	@Transactional
	public Product findProductById(int id)
	{
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class, id);
		session.close();
		return product;
	}
	
	@Transactional
	public ArrayList<Product> findProductByManufacturer(Manufacturer manufacturer)
	{
		Session session = sessionFactory.openSession();
		ArrayList<Product> productList = new ArrayList<Product>();
		System.out.print(manufacturer.getName());
		Query query= session.createQuery("from Product where manufacturer = :manufacturer ");
		query.setParameter("manufacturer", manufacturer);
		System.out.print(manufacturer.getName()+"1");
		if (query.list().size() == 0) {
			session.close();
			return new ArrayList<Product>();
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				productList.add((Product)query.list().get(i));
			}
		}
		session.close();
		return productList;
	}
	
	@Transactional
	public ArrayList<Product> returnProductList()
	{
		ArrayList<Product> productList = new ArrayList<Product>();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		if (query.list().isEmpty() && query.list().size() == 0) {
			session.close();
			return productList;
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				productList.add((Product)query.list().get(i));
			}
		}
		session.close();
		return productList;
	}
	
	public void update(Product product)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(product);
		tx.commit();
		session.close();
	}
	
	public void delete(Product product)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(product);
		tx.commit();
		session.close();
	}
}
