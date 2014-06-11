package com.shopping.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.beans.Person;

@Repository
public class PersonDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Person person)
	{
		Session session = sessionFactory.openSession();
		session.save(person);
		session.close();
	}
	
	@Transactional
	public Person findPersonById(int id)
	{
		Session session = sessionFactory.openSession();
		Person person = (Person)session.get(Person.class, id);
		session.close();
		return person;
	}
	
	public void update(Person person)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(person);
		tx.commit();
		session.close();
	}
	
	public void delete(Person person)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(person);
		tx.commit();
		session.close();
	}
	public boolean checkEmail(String email)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Person WHERE email = :email");
		query.setParameter("email", email);

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
