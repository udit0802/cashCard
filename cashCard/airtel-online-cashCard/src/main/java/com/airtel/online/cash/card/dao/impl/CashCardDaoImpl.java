package com.airtel.online.cash.card.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.airtel.online.cash.card.constants.CashCardConstants;
import com.airtel.online.cash.card.rowMapper.CashCardResponseDoRowMapper;
import com.airtel.online.cash.card.rowMapper.CashCardTransactionRowMapper;
import com.airtel.online.cash.card.vo.CashCardRequestDo;
import com.airtel.online.cash.card.vo.CashCardResponseDo;
import com.airtel.online.cash.card.vo.CashCardTransactionDo;

@Component
public class CashCardDaoImpl {

	public static final String INSERT_CASH_CARD_DETAILS = "INSERT INTO WHACK_CASH_CARD (CASH_CARD_ID,NAME,VALIDITY,REQUEST_DATE,EMAIL,REQ_AMOUNT,CASH_CARD_NAME,STATUS,ACCOUNT_NUMBER) VALUES (?,?,?,SYSDATE,?,?,?,'NOT_CREATED',?)";
	public static final String INSERT_CASH_CARD_TRANSACTION_DETAILS = "INSERT INTO WHACK_CASH_CARD_TRANSACTION (MSISDN,REQUEST_ID,MAX_REQ_AMOUNT,REQUEST_STATUS,PAYER,TIME,GIFT_ID) VALUES (?,?,?,'NOT_PAID',?,SYSDATE,?)"; 
	public static final String FETCH_CASH_CARD_DETAILS = "SELECT CASH_CARD_ID,REQUEST_DATE,EMAIL,REQ_AMOUNT,CASH_CARD_NAME,STATUS,ACCOUNT_NUMBER,PAYER,REQUEST_ID,MAX_REQ_AMOUNT,REQUEST_STATUS,RECV_AMOUNT from WHACK_CASH_CARD cashCard inner join WHACK_CASH_CARD_TRANSACTION cardtransaction on cashCard.CASH_CARD_ID = cardtransaction.GIFT_ID where cashCard.ACCOUNT_NUMBER = ?";
	public static final String PAYMENT_FOR_CASH_CARD_DETAILS = "UPDATE WHACK_CASH_CARD_TRANSACTION COLM SET COLM.RECV_AMOUNT= ?,COLM.REQUEST_STATUS='PAID' WHERE COLM.REQUEST_ID = ? AND COLM.MSISDN = ?";
	public static final String UPDATE_GIFT_CARD_STATUS = "UPDATE WHACK_CASH_CARD COLM SET COLM.STATUS = 'CARD_CREATED' WHERE COLM.CASH_CARD_ID = ?";
	public static final String FETCH_NOTIFICATION = "SELECT MSISDN,REQUEST_ID,MAX_REQ_AMOUNT,REQUEST_STATUS,PAYER,TIME,GIFT_ID,RECV_AMOUNT FROM WHACK_CASH_CARD_TRANSACTION WHERE MSISDN = ? OR PAYER = ? ORDER BY TIME DESC";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertCashCardDetails(CashCardRequestDo cashCardRequestDo){
		jdbcTemplate.update(INSERT_CASH_CARD_DETAILS, new Object[]{cashCardRequestDo.getCashCardId(),cashCardRequestDo.getCashCardOwner(),cashCardRequestDo.getValidity(),cashCardRequestDo.getEmail(),cashCardRequestDo.getRequestedAmount(),cashCardRequestDo.getCashCardName(),cashCardRequestDo.getAccountNumber()});
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertCashCardTransactionDetails(CashCardTransactionDo cashCardTransactionDo){
		jdbcTemplate.update(INSERT_CASH_CARD_TRANSACTION_DETAILS, new Object[]{cashCardTransactionDo.getMsisdn(),cashCardTransactionDo.getRequestId(),cashCardTransactionDo.getReqAmount(),cashCardTransactionDo.getPayer(),cashCardTransactionDo.getGiftId()});
	}
	
	public List<CashCardResponseDo> fetchCardDetails(String requesterSiNumber){
		try{
			return jdbcTemplate.query(FETCH_CASH_CARD_DETAILS,
					new Object[] {requesterSiNumber},
					new CashCardResponseDoRowMapper());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public String makePayment(String amount, String mobileNumber, String reqId){
		try{
			jdbcTemplate.update(PAYMENT_FOR_CASH_CARD_DETAILS, new Object[]{amount, reqId, mobileNumber});
			return CashCardConstants.SUCCESS;
		}catch(Exception ex){
			return CashCardConstants.FAILURE;
		}
	}
	
	public String updateCardStatus(String giftCardId){
		try{
			jdbcTemplate.update(UPDATE_GIFT_CARD_STATUS, new Object[]{giftCardId});
			return CashCardConstants.SUCCESS;
		}catch(Exception ex){
			return CashCardConstants.SUCCESS;
		}
	}
	
	public List<CashCardTransactionDo> fetchRequesterNotification(String msisdn){
		try{
			return jdbcTemplate.query(FETCH_NOTIFICATION,
					new Object[] {msisdn,msisdn},
					new CashCardTransactionRowMapper());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
