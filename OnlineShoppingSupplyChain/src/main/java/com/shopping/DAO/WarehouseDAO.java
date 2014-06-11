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
import com.shopping.beans.Warehouse;

@Repository
public class WarehouseDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Warehouse warehouse)
	{
		Session session = sessionFactory.openSession();
		session.save(warehouse);
		session.close();
	}
	
	@Transactional
	public Warehouse findWarehouseById(int id)
	{
		Session session = sessionFactory.openSession();
		Warehouse warehouse = (Warehouse)session.get(Warehouse.class, id);
		session.close();
		return warehouse;
	}
	
	public void update(Warehouse warehouse)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(warehouse);
		tx.commit();
		session.close();
	}
	
	public void delete(Warehouse warehouse)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(warehouse);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public ArrayList<Warehouse> findWarehouseByManufacturer(Manufacturer manufacturer)
	{
		Session session = sessionFactory.openSession();
		ArrayList<Warehouse> warehouseList = new ArrayList<Warehouse>();
		Query query= session.createQuery("from Warehouse where manufacturer = :manufacturer ");
		query.setParameter("manufacturer", manufacturer);
		if (query.list().size() == 0) {
			session.close();
			return null;
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				warehouseList.add((Warehouse)query.list().get(i));
			}
		}
		session.close();
		return warehouseList;
	}

}
