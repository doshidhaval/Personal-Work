package com.shopping.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.shopping.beans.UserAccount;

@Repository
public class UserAccountDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(UserAccount userAccount)
	{
		Session session = sessionFactory.openSession();
		session.save(userAccount);
		session.close();
	}
	
	
	public UserAccount findUserAccountById(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserAccount userAccount = (UserAccount)session.get(UserAccount.class, id);
		tx.commit();
		session.close();
		return userAccount;
	}
	
	public UserAccount findUserAccountByUserName(String username,String password)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserAccount userAccount =null;
		Query query = session.createQuery("from UserAccount WHERE username = :username");
		query.setParameter("username", username);

		if (query.list().isEmpty() && query.list().size() == 0) {
			System.out.println("empty");
			userAccount = null;
		} 
		else{
			UserAccount userAccount1 = (UserAccount) query.list().get(0);
			if (userAccount1.getUsername().equals(username) && userAccount1.getPassword().equals(password)) 
			{
				userAccount=userAccount1;
			}
		}
		tx.commit();
		session.close();
		return userAccount;
	}
	
	public boolean checkUserName(String username)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UserAccount WHERE username = :username");
		query.setParameter("username", username);

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
	
	public void update(UserAccount userAccount)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(userAccount);
		tx.commit();
		session.close();
	}
	
	public void delete(UserAccount userAccount)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(userAccount);
		tx.commit();
		session.close();
	}

}
