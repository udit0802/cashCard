package com.airtel.online.cash.card.vo;

import java.sql.Timestamp;

public class CashCardResponseDo {

	private String cashCardId;
	
	private Timestamp cardRequestDate;
	
	private String email;
	
	private String reqAmount;
	
	private String cashCardName;
	
	private String cardStatus;
	
	private String accountNumber;
	
	private String payerSiNumber;
	
	private String requestId;
	
	private String maxRequestedAmountFromPayer;
	
	private String requestStatus;
	
	private String receivedAmount;

	public String getCashCardId() {
		return cashCardId;
	}

	public void setCashCardId(String cashCardId) {
		this.cashCardId = cashCardId;
	}

	public Timestamp getCardRequestDate() {
		return cardRequestDate;
	}

	public void setCardRequestDate(Timestamp cardRequestDate) {
		this.cardRequestDate = cardRequestDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(String reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getCashCardName() {
		return cashCardName;
	}

	public void setCashCardName(String cashCardName) {
		this.cashCardName = cashCardName;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPayerSiNumber() {
		return payerSiNumber;
	}

	public void setPayerSiNumber(String payerSiNumber) {
		this.payerSiNumber = payerSiNumber;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getMaxRequestedAmountFromPayer() {
		return maxRequestedAmountFromPayer;
	}

	public void setMaxRequestedAmountFromPayer(String maxRequestedAmountFromPayer) {
		this.maxRequestedAmountFromPayer = maxRequestedAmountFromPayer;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
}
