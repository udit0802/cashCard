package com.airtel.online.cash.card.vo;

import java.sql.Timestamp;

public class CashCardTransactionDo {

	private String msisdn;
	
	private String requestId;
	
	private String reqAmount;
	
	private String status;
	
	private String payer;
	
	private Timestamp time;
	
	private String giftId;
	
	private String recvAmount;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(String reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

	public String getRecvAmount() {
		return recvAmount;
	}

	public void setRecvAmount(String recvAmount) {
		this.recvAmount = recvAmount;
	}
}
