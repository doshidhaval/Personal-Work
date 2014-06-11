package com.shopping.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.beans.Manufacturer;
import com.shopping.beans.Person;
import com.shopping.beans.UserAccount;


@Repository
public class ManufacturerDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Manufacturer manufacturer)
	{
		Session session = sessionFactory.openSession();
		session.save(manufacturer);
		session.close();
	}
	
	@Transactional
	public Manufacturer findManufacturerById(int id)
	{
		Session session = sessionFactory.openSession();
		Manufacturer manufacturer = (Manufacturer)session.get(Manufacturer.class, id);
		session.close();
		return manufacturer;
	}
	
	@Transactional
	public ArrayList<Manufacturer> returnManufacturerList()
	{
		ArrayList<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Manufacturer");
		if (query.list().isEmpty() && query.list().size() == 0) {
			session.close();
			return null;
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				manufacturerList.add((Manufacturer)query.list().get(i));
			}
		}
		session.close();
		return manufacturerList;
	}
	
	@Transactional
	public ArrayList<Manufacturer> returnUnverifiedManufacturerList()
	{
		ArrayList<Manufacturer> manufacturerList = new ArrayList<Manufacturer>();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Manufacturer");
		if (query.list().isEmpty() && query.list().size() == 0) {
			session.close();
			return null;
		}
		else
		{
			for(int i=0; i<query.list().size();i++ )
			{
				manufacturerList.add((Manufacturer)query.list().get(i));
			}
		}
		
		ArrayList<Manufacturer> tempList = new ArrayList<Manufacturer>();
		
		for(Manufacturer m: manufacturerList){
			List<Person> personList = m.getPerson_List();
			System.out.println(m.getName());
			for(Person p: personList){
				
				System.out.println(p.getFname());
				UserAccount ua = p.getUser_Account();
				System.out.println(ua.getUsername());
				if(ua.getStatus().equalsIgnoreCase(UserAccount.Waiting)){
					System.out.println(m.getName());
					tempList.add(m);
					break;				
				}
			}
		}
		session.close();
		return tempList;
	
	}
	
	public void update(Manufacturer manufacturer)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(manufacturer);
		tx.commit();
		session.close();
	}
	
	public void delete(Manufacturer manufacturer)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(manufacturer);
		tx.commit();
		session.close();
	}
	
	public boolean checkMName(String name)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Manufacturer WHERE name = :name");
		query.setParameter("name", name);

		if (query.list().isEmpty() && query.list().size() == 0) {
			tx.commit();
			session.close();
			return false;
		} 
		else{
			
			tx.commit();
			session.close();
			return true;
		}
	}
	

}
