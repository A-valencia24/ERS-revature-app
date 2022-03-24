package com.training.ers.model;

import java.util.Objects;

public class manager {
	private int managerId;
	private String managerName;
	private String password;
	private String approvedBy;
	private String status;
	private float amount;
	private String purpose;
	
	public manager() {
		
	}
	public manager(int managerId, String managerName, String password,String approvedBy, String status, float amount, String purpose) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.password = password;
		this.amount = amount;
		this.approvedBy = approvedBy;
		this.purpose = purpose;
		this.status = status;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, approvedBy, managerId, managerName, password, purpose, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		manager other = (manager) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount)
				&& Objects.equals(approvedBy, other.approvedBy) && managerId == other.managerId
				&& Objects.equals(managerName, other.managerName) && Objects.equals(password, other.password)
				&& Objects.equals(purpose, other.purpose) && Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "manager [managerId=" + managerId + ", managerName=" + managerName + ", password=" + password
				+ ", approvedBy=" + approvedBy + ", status=" + status + ", amount=" + amount + ", purpose=" + purpose
				+ "]";
	}
	
	
}
