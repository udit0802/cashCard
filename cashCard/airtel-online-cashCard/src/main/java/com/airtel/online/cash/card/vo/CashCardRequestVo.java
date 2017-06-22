package com.airtel.online.cash.card.vo;

import java.util.List;

public class CashCardRequestVo {

	private String cashCardId;
	
	private String cashCardOwner;
	
	private String cashCardName;
	
	private String accountNumber;
	
	private String emailId;
	
	private String totalRequestedAmount;
	
	private List<UserVo> userVos;

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

	public String getCashCardName() {
		return cashCardName;
	}

	public void setCashCardName(String cashCardName) {
		this.cashCardName = cashCardName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTotalRequestedAmount() {
		return totalRequestedAmount;
	}

	public void setTotalRequestedAmount(String totalRequestedAmount) {
		this.totalRequestedAmount = totalRequestedAmount;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<UserVo> getUserVos() {
		return userVos;
	}

	public void setUserVos(List<UserVo> userVos) {
		this.userVos = userVos;
	}
	
}
