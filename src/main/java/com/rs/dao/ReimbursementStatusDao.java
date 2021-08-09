package com.rs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.models.ReimbStatus;
import com.rs.utils.HibernateUtil;


public class ReimbursementStatusDao {
	
	public void insert(ReimbStatus s) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(s);
		tx.commit();
	}
	
	public ReimbStatus getStatusById(int id) {
		Session ses = HibernateUtil.getSession();
		ReimbStatus s = ses.createQuery("from ReimbursementStatus where id ="+id,ReimbStatus.class).uniqueResult();
		return s;
	}

}
