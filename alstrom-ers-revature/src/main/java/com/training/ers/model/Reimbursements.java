package com.training.ers.model;

import java.util.Objects;

public class Reimbursements {
	private String username;
	private String status;
	private String purpose;
	private float amount;
	
	public Reimbursements(String username, String status, String purpose, float amount) {
		super();
		this.amount = amount;
		this.purpose = purpose;
		this.status = status;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, purpose, status, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount)
				&& Objects.equals(purpose, other.purpose) && Objects.equals(status, other.status)
				&& Objects.equals(username, other.username);
	}
	
	
	

}
