package com.rs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.models.UserRole;
import com.rs.utils.HibernateUtil;

public class UserRoleDao {
	
	public void insert(UserRole r) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(r);
		tx.commit();
	}
	
	public UserRole getUserRoleById(int id) {
		Session ses = HibernateUtil.getSession();
		UserRole u = ses.createQuery("from UserRole where id ="+id,UserRole.class).uniqueResult();
		return u;
	}

}
