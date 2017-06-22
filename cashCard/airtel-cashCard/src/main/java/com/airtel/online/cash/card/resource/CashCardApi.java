package com.airtel.online.cash.card.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.online.cash.card.constants.CashCardConstants;
import com.airtel.online.cash.card.service.impl.CashCardServiceImpl;
import com.airtel.online.cash.card.vo.CashCardRequestVo;
import com.airtel.online.cash.card.vo.CashCardResponseVo;
import com.airtel.online.cash.card.vo.MyAirtelAppResponseVo;
import com.airtel.online.cash.card.vo.NotificationResponseVo;
import com.airtel.online.cash.card.vo.PaymentRequestVo;
import com.airtel.online.cash.card.vo.ResponseVo;

@RestController
@RequestMapping(value = "/cash/card")
public class CashCardApi {
	
	@Autowired
	private CashCardServiceImpl cashCardServiceImpl;

	@RequestMapping(value = "/v1/make/payment", method = RequestMethod.POST)
	public MyAirtelAppResponseVo makePayment(@RequestBody PaymentRequestVo paymentRequestVo){
		MyAirtelAppResponseVo myAirtelAppResponseVo = null;
		try{
			ResponseVo<String> responseVo = new ResponseVo<>();
			responseVo.setResponse(cashCardServiceImpl.makePayment(paymentRequestVo.getRecvAmount(), paymentRequestVo.getCashCardRequesterMobileNumber(), paymentRequestVo.getRequestId()));
			myAirtelAppResponseVo = new MyAirtelAppResponseVo(CashCardConstants.SUCCESS,0,responseVo,null,200);
		}catch (Exception e) {
			new MyAirtelAppResponseVo(CashCardConstants.FAILURE,-1,null,CashCardConstants.ERROR_MESSAGE,500);
		}
		return myAirtelAppResponseVo;
	}
	
	@RequestMapping(value = "/v1/create/cash/card", method = RequestMethod.POST)
	public MyAirtelAppResponseVo createCashCard(@RequestBody CashCardRequestVo cashCardRequestVo){
		MyAirtelAppResponseVo myAirtelAppResponseVo = null;
		try{
			ResponseVo<String> responseVo = new ResponseVo<>();
			responseVo.setResponse(cashCardServiceImpl.createCashCard(cashCardRequestVo));
			myAirtelAppResponseVo = new MyAirtelAppResponseVo(CashCardConstants.SUCCESS,0,responseVo,null,200);	
		}catch (Exception e) {
			new MyAirtelAppResponseVo(CashCardConstants.FAILURE,-1,null,CashCardConstants.ERROR_MESSAGE,500);
		}
		return myAirtelAppResponseVo;
	}
	
	@RequestMapping(value = "/v1/fetch/card/details", method = RequestMethod.GET)
	public MyAirtelAppResponseVo fetchCardDetails(String requesterSiNumber){
		MyAirtelAppResponseVo myAirtelAppResponseVo = null;
		try{
			ResponseVo<List<CashCardResponseVo>> responseVo = new ResponseVo<>();
			responseVo.setResponse(cashCardServiceImpl.fetchCashCardDetails(requesterSiNumber));
			myAirtelAppResponseVo = new MyAirtelAppResponseVo(CashCardConstants.SUCCESS,0,responseVo,null,200);
		}catch (Exception e) {
			new MyAirtelAppResponseVo(CashCardConstants.FAILURE,-1,null,CashCardConstants.ERROR_MESSAGE,500);
		}
		return myAirtelAppResponseVo;
	}
	
	@RequestMapping(value = "/v1/update/card/status", method = RequestMethod.GET)
	public MyAirtelAppResponseVo updateCardStatus(String cashCardId){
		MyAirtelAppResponseVo myAirtelAppResponseVo = null;
		try{
			ResponseVo<String> responseVo = new ResponseVo<>();
			responseVo.setResponse(cashCardServiceImpl.updateCardStatus(cashCardId));
			myAirtelAppResponseVo = new MyAirtelAppResponseVo(CashCardConstants.SUCCESS,0,responseVo,null,200);
		}catch (Exception e) {
			new MyAirtelAppResponseVo(CashCardConstants.FAILURE,-1,null,CashCardConstants.ERROR_MESSAGE,500);
		}
		return myAirtelAppResponseVo;
	}
	
	@RequestMapping(value = "/v1/fetch/notifications",method = RequestMethod.GET)
	public MyAirtelAppResponseVo getNotifications(String msisdn){
		MyAirtelAppResponseVo myAirtelAppResponseVo = null;
		try{
			ResponseVo<NotificationResponseVo> responseVo = new ResponseVo<>();
			responseVo.setResponse(cashCardServiceImpl.fetchNotificationsForNumber(msisdn));
			myAirtelAppResponseVo = new MyAirtelAppResponseVo(CashCardConstants.SUCCESS,0,responseVo,null,200);
		}catch (Exception e) {
			new MyAirtelAppResponseVo(CashCardConstants.FAILURE,-1,null,CashCardConstants.ERROR_MESSAGE,500);
		}
		return myAirtelAppResponseVo;
	}
}
