package com.airtel.online.cash.card.vo;

import java.util.List;

public class NotificationResponseVo {

	private List<CashCardTransactionVo> notifications;

	public List<CashCardTransactionVo> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<CashCardTransactionVo> notifications) {
		this.notifications = notifications;
	}
	
}
