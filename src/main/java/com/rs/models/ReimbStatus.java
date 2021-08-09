package com.rs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="rstatus")
public class ReimbStatus {
	@Id
	@Column(name = "re_status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "re_status")
	private ReimbStatus reimbursement_status;
	
	public ReimbStatus() {
		
	}
	
	public ReimbStatus(int id, ReimbStatus reimbursement_status) {
		super();
		this.id=id;
		this.reimbursement_status=reimbursement_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReimbStatus getReimbursement_status() {
		return reimbursement_status;
	}

	public void setReimbursement_status(ReimbStatus reimbursement_status) {
		this.reimbursement_status = reimbursement_status;
	}

	@Override
	public String toString() {
		return "[ ReimbStatus"+reimbursement_status+ "]";
	}
	
	
}
