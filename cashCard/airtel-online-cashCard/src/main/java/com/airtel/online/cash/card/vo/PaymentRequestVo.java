package com.airtel.online.cash.card.vo;

public class PaymentRequestVo {

	private String recvAmount;
	
	private String cashCardRequesterMobileNumber;
	
	private String requestId;

	public String getRecvAmount() {
		return recvAmount;
	}

	public void setRecvAmount(String recvAmount) {
		this.recvAmount = recvAmount;
	}

	public String getCashCardRequesterMobileNumber() {
		return cashCardRequesterMobileNumber;
	}

	public void setCashCardRequesterMobileNumber(String cashCardRequesterMobileNumber) {
		this.cashCardRequesterMobileNumber = cashCardRequesterMobileNumber;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
