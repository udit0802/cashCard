package com.airtel.online.cash.card.vo;

import java.sql.Timestamp;

public class CashCardRequestDo {

	private String cashCardId;
	
	private String cashCardOwner;
	
	private int validity;
	
	private Timestamp creationDate;
	
	private Timestamp reqDate;
	
	private String email;
	
	private String requestedAmount;
	
	private String receivedAmount;
	
	private String cashCardName;
	
	private String status;
	
	private String availableAmount;
	
	private String accountNumber;

	public String getCashCardId() {
		return cashCardId;
	}

	public void setCashCardId(String cashCardId) {
		this.cashCardId = cashCardId;
	}

	public String getCashCardOwner() {
		return cashCardOwner;
	}

	public void setCashCardOwner(String cashCardOwner) {
		this.cashCardOwner = cashCardOwner;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Timestamp getReqDate() {
		return reqDate;
	}

	public void setReqDate(Timestamp reqDate) {
		this.reqDate = reqDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(String requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public String getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public String getCashCardName() {
		return cashCardName;
	}

	public void setCashCardName(String cashCardName) {
		this.cashCardName = cashCardName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(String availableAmount) {
		this.availableAmount = availableAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "CashCardRequestDo [cashCardId=" + cashCardId + ", cashCardOwner=" + cashCardOwner + ", validity="
				+ validity + ", creationDate=" + creationDate + ", reqDate=" + reqDate + ", email=" + email
				+ ", requestedAmount=" + requestedAmount + ", receivedAmount=" + receivedAmount + ", cashCardName="
				+ cashCardName + ", status=" + status + ", availableAmount=" + availableAmount + ", accountNumber="
				+ accountNumber + "]";
	}
}
