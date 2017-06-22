package com.airtel.online.cash.card.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airtel.online.cash.card.constants.CashCardConstants;
import com.airtel.online.cash.card.converter.CashCardRequestVoToCashCardRequestDoConverter;
import com.airtel.online.cash.card.converter.CashCardResponseDoToCashCardResponseVoConverter;
import com.airtel.online.cash.card.converter.CashCardTransactionDoToCashCardTransactionVoConverter;
import com.airtel.online.cash.card.dao.impl.CashCardDaoImpl;
import com.airtel.online.cash.card.vo.CashCardRequestDo;
import com.airtel.online.cash.card.vo.CashCardRequestVo;
import com.airtel.online.cash.card.vo.CashCardResponseDo;
import com.airtel.online.cash.card.vo.CashCardResponseVo;
import com.airtel.online.cash.card.vo.CashCardTransactionDo;
import com.airtel.online.cash.card.vo.NotificationResponseVo;
import com.airtel.online.cash.card.vo.UserVo;

@Component
public class CashCardServiceImpl {

	@Autowired
	private CashCardDaoImpl cashCardDaoImpl;
	
	@Autowired
	private CashCardRequestVoToCashCardRequestDoConverter cardRequestVoToCashCardRequestDoConverter;
	
	@Autowired
	private CashCardResponseDoToCashCardResponseVoConverter cashCardResponseDoToCashCardResponseVoConverter;
	
	@Autowired
	private CashCardTransactionDoToCashCardTransactionVoConverter cashCardTransactionDoToCashCardTransactionVoConverter;
	
	public String createCashCard(CashCardRequestVo cashCardRequestVo){
		try{
			CashCardRequestDo cashCardRequestDo = cardRequestVoToCashCardRequestDoConverter.convert(cashCardRequestVo);
			cashCardDaoImpl.insertCashCardDetails(cashCardRequestDo);
			for(UserVo user : cashCardRequestVo.getUserVos()){
				CashCardTransactionDo cashCardTransactionDo = new CashCardTransactionDo();
				cashCardTransactionDo.setMsisdn(cashCardRequestVo.getAccountNumber());
				cashCardTransactionDo.setRequestId(user.getRequestId());
				cashCardTransactionDo.setReqAmount(user.getRequestedAmount());
				cashCardTransactionDo.setPayer(user.getPayerNumber());
				cashCardTransactionDo.setGiftId(cashCardRequestVo.getCashCardId());
				cashCardDaoImpl.insertCashCardTransactionDetails(cashCardTransactionDo);
			}
			return CashCardConstants.SUCCESS;
		}catch (Exception e) {
			return CashCardConstants.SUCCESS;
		}
	}
	
	public List<CashCardResponseVo> fetchCashCardDetails(String requesterSiNumber){
		List<CashCardResponseDo> cashCardResponseDos = cashCardDaoImpl.fetchCardDetails(requesterSiNumber);
		return cashCardResponseDoToCashCardResponseVoConverter.convert(cashCardResponseDos);
	}
	
	public String makePayment(String amount, String mobileNumber, String reqId){
		return cashCardDaoImpl.makePayment(amount, mobileNumber, reqId);
	}
	
	public String updateCardStatus(String giftId){
		return cashCardDaoImpl.updateCardStatus(giftId);
	}
	
	public NotificationResponseVo fetchNotificationsForNumber(String msisdn){
		List<CashCardTransactionDo> requesterAndPayerDos = cashCardDaoImpl.fetchRequesterNotification(msisdn);
		NotificationResponseVo notificationResponseVo = new NotificationResponseVo();
		notificationResponseVo.setNotifications(cashCardTransactionDoToCashCardTransactionVoConverter.convert(requesterAndPayerDos));
		return notificationResponseVo;
	}
}
