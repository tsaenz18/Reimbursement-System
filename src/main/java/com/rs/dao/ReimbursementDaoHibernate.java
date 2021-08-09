package com.rs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;


import com.rs.models.Reimbursement;
import com.rs.models.ReimbStatus;
import com.rs.models.ReimbType;
import com.rs.models.User;
import com.rs.utils.HibernateUtil;

public class ReimbursementDaoHibernate implements ReimbursementDao{
	
	public List<Reimbursement> getAllReimbursments() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}

	public Reimbursement getReimbursementById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement r = ses.get(Reimbursement.class, id);
		return r;
	}

	public void createReimbursement(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(r);
		tx.commit();
	}

	public void updateReimbursement(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.merge(r);
		tx.commit();
	}

	public void deleteReimbursement(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(r);
		tx.commit();
	}

	public void deleteReimbursementById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement r = ses.get(Reimbursement.class, id);
		Transaction tx = ses.beginTransaction();
		ses.delete(r);
		tx.commit();
	}


	public void updateReimbursementByArgs(int id, ReimbType type, double amount, String submitteddate, String resolveddate, String description, ReimbStatus status, User employeeId, User manager) {
		Session ses = HibernateUtil.getSession();
		Reimbursement r = new Reimbursement(id, type, amount, submitteddate, resolveddate, description, status, employeeId, manager);
		Transaction tx = ses.beginTransaction();
		ses.merge(r);
		tx.commit();
	}
	

	public List<Reimbursement> getAllPendingReimbursments() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where re_status_id = 3", Reimbursement.class).list();
		return rList;
	}


	public List<Reimbursement> getAllAcceptedReimbursments() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where re_status_id = 4", Reimbursement.class).list();
		return rList;
	}
	
	
	public List<Reimbursement> getAllDeniedReimbursments() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where re_status_id = 5", Reimbursement.class).list();
		return rList;
	}
	
	
	public List<Reimbursement> getAllPendingReimbursmentsForUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where re_status_id = 3", Reimbursement.class).list();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		for(Reimbursement curr:rList) {
			if(curr.getUserConnection()==u) {
				result.add(curr);
			}
		}
		return result;
	}
	
	
	public List<Reimbursement> getAllAcceptedReimbursmentsForUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where re_status_id = 4", Reimbursement.class).list();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		for(Reimbursement curr:rList) {
			if(curr.getUserConnection()==u) {
				result.add(curr);
			}
		}
		return result;
	}
	
	
	public List<Reimbursement> getAllDeniedReimbursmentsForUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement where re_status_id = 5", Reimbursement.class).list();
		List<Reimbursement> result = new ArrayList<Reimbursement>();
		for(Reimbursement curr:rList) {
			if(curr.getUserConnection()==u) {
				result.add(curr);
			}
		}
		return result;
	}

	public void updateReimbursementByArgs(int id, com.rs.enums.ReimbType type, double amount, String submitteddate,
			String resolveddate, String description, com.rs.enums.ReimbStatus status, User employeeId, User Manager) {
		// TODO Auto-generated method stub
		
	}
}


