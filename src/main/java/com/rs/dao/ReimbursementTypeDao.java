package com.rs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.models.ReimbStatus;
import com.rs.models.ReimbType;
import com.rs.utils.HibernateUtil;

public class ReimbursementTypeDao {
	
	public void insert(ReimbType t) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(t);
		tx.commit();
	}
	
	public ReimbType getTypeById(int id) {
		Session ses = HibernateUtil.getSession();
		ReimbType t = ses.createQuery("from ReimbursementType where id ="+id,ReimbType.class).uniqueResult();
		return t;
	}
}
