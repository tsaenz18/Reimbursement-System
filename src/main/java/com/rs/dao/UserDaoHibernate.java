package com.rs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.models.User;
import com.rs.utils.HibernateUtil;

public class UserDaoHibernate implements UserDao{

	
	public List<User> getAllUsers() {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User", User.class).list();
		return uList;
	}


	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User where username='"+username+"'", User.class).list();
		if(uList.size() == 0) {
			return null;
		}
		return uList.get(0);
	}
	
	
	public User getUserById(int id) {
		Session ses = HibernateUtil.getSession();
		User u = ses.createQuery("from User where id ="+id,User.class).uniqueResult();
		return u;
	}

	
	public void createUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(u);
		tx.commit();
	}


	public void updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.merge(u);
		tx.commit();
	}

	
	public void deleteUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(u);
		tx.commit();
	}
	
	

}