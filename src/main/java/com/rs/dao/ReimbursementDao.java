package com.rs.dao;

import java.util.List;

import com.rs.enums.ReimbType;
import com.rs.enums.ReimbStatus;
import com.rs.models.Reimbursement;
import com.rs.models.User;

public interface ReimbursementDao {
	
	List<Reimbursement> getAllReimbursments();
	
	Reimbursement getReimbursementById(int id);
	
	void createReimbursement(Reimbursement r);

	void updateReimbursement(Reimbursement r);
	
	void deleteReimbursement(Reimbursement r);
	
	void deleteReimbursementById(int id);
	
	void updateReimbursementByArgs(int id, ReimbType type, double amount, String submitteddate, String resolveddate, String description, ReimbStatus status, User employeeId, User Manager);
	
	List<Reimbursement> getAllPendingReimbursments();
	
	List<Reimbursement> getAllAcceptedReimbursments();
	
	List<Reimbursement> getAllDeniedReimbursments();
	
	List<Reimbursement> getAllPendingReimbursmentsForUser(User u);
	
	List<Reimbursement> getAllAcceptedReimbursmentsForUser(User u);
	
	List<Reimbursement> getAllDeniedReimbursmentsForUser(User u);
}