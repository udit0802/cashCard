package com.airtel.online.cash.card.vo;

import java.util.List;

public class CashCardResponseVo {

	private String cashCardId;
	
	private String cashCardRequestDate;
	
	private String receiverEmailId;
	
	private String cashCardRequestAmount;
	
	private String cashCardName;
	
	private String cashCardStatus;
	
	private String accountNumber;
	
	private List<UserVo> contributors;

	public String getCashCardId() {
		return cashCardId;
	}

	public void setCashCardId(String cashCardId) {
		this.cashCardId = cashCardId;
	}

	public String getCashCardRequestDate() {
		return cashCardRequestDate;
	}

	public void setCashCardRequestDate(String cashCardRequestDate) {
		this.cashCardRequestDate = cashCardRequestDate;
	}

	public String getReceiverEmailId() {
		return receiverEmailId;
	}

	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}

	public String getCashCardRequestAmount() {
		return cashCardRequestAmount;
	}

	public void setCashCardRequestAmount(String cashCardRequestAmount) {
		this.cashCardRequestAmount = cashCardRequestAmount;
	}

	public String getCashCardName() {
		return cashCardName;
	}

	public void setCashCardName(String cashCardName) {
		this.cashCardName = cashCardName;
	}

	public String getCashCardStatus() {
		return cashCardStatus;
	}

	public void setCashCardStatus(String cashCardStatus) {
		this.cashCardStatus = cashCardStatus;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<UserVo> getContributors() {
		return contributors;
	}

	public void setContributors(List<UserVo> contributors) {
		this.contributors = contributors;
	}
	
}
