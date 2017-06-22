package com.airtel.online.cash.card.vo;

public class MyAirtelAppResponseVo {
	private String status;
	private int responseCode;
	private Object data;
	private String errorMessage;
	private String errorMsg;
	private int errorCode;

	public MyAirtelAppResponseVo() {
		this.status = "success";
		this.responseCode = 0;
		this.errorCode = 0;
	}

	public MyAirtelAppResponseVo(String status, int responseCode, Object data, String errorMessage, int errorCode) {
		this.status = status;
		this.responseCode = responseCode;
		this.data = data;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.errorMsg = errorMessage;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		this.errorMsg = errorMessage;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String toString() {
		return "MyAirtelAppResponseVO [status=" + this.status + ", responseCode=" + this.responseCode + ", data="
				+ this.data + ", errorMessage=" + this.errorMessage + ", errorMsg=" + this.errorMsg + ", errorCode="
				+ this.errorCode + "]";
	}
}
