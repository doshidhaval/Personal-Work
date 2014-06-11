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
import com.shopping.beans.OrderItem;
import com.shopping.beans.Person;


@Repository
public class CustomerOrderDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(CustomerOrder customerOrder)
	{
		Session session = sessionFactory.openSession();
		session.save(customerOrder);
		session.close();
	}
	
	@Transactional
	public CustomerOrder findCustomerOrderById(int id)
	{
		Session session = sessionFactory.openSession();
		CustomerOrder customerOrder = (CustomerOrder)session.get(CustomerOrder.class, id);
		session.close();
		return customerOrder;
	}
	
	public void update(CustomerOrder customerOrder)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(customerOrder);
		tx.commit();
		session.close();
	}
	
	public void delete(CustomerOrder customerOrder)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customerOrder);
		tx.commit();
		session.close();
	}
	public ArrayList<CustomerOrder> findOrdersByCustomer(Person person)
	{
		Session session = sessionFactory.openSession();
		ArrayList<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
		Query query= session.createQuery("from CustomerOrder where person = :person ");
		query.setParameter("person",person);
		if (query.list().size() == 0) {
			session.close();
			return null;
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				customerOrderList.add((CustomerOrder)query.list().get(i));
			}
		}
		session.close();
		return customerOrderList;
		
	}
	
	public ArrayList<CustomerOrder> findIncompleteOrdersByCustomer(Person person)
	{
		Session session = sessionFactory.openSession();
		ArrayList<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
		Query query= session.createQuery("from CustomerOrder where person = :person ");
		query.setParameter("person",person);
		if (query.list().size() == 0) {
			session.close();
			return null;
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				CustomerOrder customerOrder = (CustomerOrder)query.list().get(i);
				if(customerOrder.getStatus().equalsIgnoreCase(CustomerOrder.Ordering))
				{
					customerOrderList.add((CustomerOrder)query.list().get(i));
				}
			}
		}
		session.close();
		return customerOrderList;
		
	}
	
	@Transactional
	public ArrayList<CustomerOrder> findOrderItemsByStatus(String status)
	{
		Session session = sessionFactory.openSession();
		ArrayList<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
		Query query= session.createQuery("from CustomerOrder where status = :status ");
		query.setParameter("status", status);
		if (query.list().size() == 0) {
			session.close();
			return new ArrayList<CustomerOrder>();
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				customerOrderList.add((CustomerOrder)query.list().get(i));
			}
		}
		session.close();
		return customerOrderList;
	}
	


}
