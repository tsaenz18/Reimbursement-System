package com.rs.services;

import java.util.ArrayList;
import java.util.List;

import com.rs.dao.ReimbursementDao;
import com.rs.enums.ReimbType;
import com.rs.enums.ReimbStatus;
import com.rs.models.Reimbursement;

import com.rs.models.User;

public class ReimbursementService {

	private ReimbursementDao rDao;
	
	public ReimbursementService(ReimbursementDao r) {
		this.rDao = r;
	}
	
	public void addReimbursement(ReimbType type, double amount, String submitteddate, String description, ReimbStatus status, User employeeid) {
		Reimbursement r = new Reimbursement(type, amount, submitteddate, description, status, employeeid);
		rDao.createReimbursement(r);
	}
	
	public List<Reimbursement> getAllReimbursements(){
		return rDao.getAllReimbursments();
	}
	
	public void updateReimbursement(int id, ReimbType type, double amount, String submitteddate, String resolveddate, String description, ReimbStatus status, User employeeid, User manager) {
		rDao.updateReimbursementByArgs(id, type, amount, submitteddate, resolveddate, description, status, employeeid, manager);
	}
	
	public void deleteReimbursement(int id){
		rDao.deleteReimbursementById(id);
	}
	
	public List<Reimbursement> getAllPendingReimbursements(){
		return rDao.getAllPendingReimbursments();
	}
	
	public List<Reimbursement> getAllAcceptedReimbursements(){
		return rDao.getAllAcceptedReimbursments();
	}
	
	public List<Reimbursement> getAllDeniedReimbursements(){
		return rDao.getAllDeniedReimbursments();
	}
	
	public List<Reimbursement> getAllReimbursementsForUser(User u){
		List<Reimbursement> superList = new ArrayList<Reimbursement>();
		List<Reimbursement> a = rDao.getAllAcceptedReimbursmentsForUser(u);
		for(Reimbursement re:a) {
			superList.add(re);
		}
		List<Reimbursement> p = rDao.getAllPendingReimbursmentsForUser(u);
		for(Reimbursement r:p) {
			superList.add(r);
		}
		List<Reimbursement> d = rDao.getAllDeniedReimbursmentsForUser(u);
		for(Reimbursement rd:d) {
			superList.add(rd);
		}
		return superList;
	}

	
}