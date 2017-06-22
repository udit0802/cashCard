package com.airtel.online.cash.card.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.airtel.online.cash.card.utils.CashCardUtil;
import com.airtel.online.cash.card.vo.CashCardResponseDo;
import com.airtel.online.cash.card.vo.CashCardResponseVo;
import com.airtel.online.cash.card.vo.UserVo;

@Component
public class CashCardResponseDoToCashCardResponseVoConverter {
	
	Map<String,String> giftIdPresentMap = new HashMap<String, String>();
	
	public List<CashCardResponseVo> convert(List<CashCardResponseDo> cashCardResponseDos){
		if(CashCardUtil.isEmpty(cashCardResponseDos))
			return null;
		List<CashCardResponseVo> cashCardResponseVos = new ArrayList<CashCardResponseVo>();
		for(CashCardResponseDo cashCardResponseDo : cashCardResponseDos){
			CashCardResponseVo cashCardResponseVo = new CashCardResponseVo();
			if(giftIdPresentMap.get(cashCardResponseDo.getCashCardId()) == null){
				cashCardResponseVo.setCashCardId(cashCardResponseDo.getCashCardId());
				cashCardResponseVo.setCashCardRequestDate(CashCardUtil.convertTimestampToFormattedDate(cashCardResponseDo.getCardRequestDate()));
				cashCardResponseVo.setReceiverEmailId(cashCardResponseDo.getEmail());
				cashCardResponseVo.setCashCardRequestAmount(cashCardResponseDo.getReqAmount());
				cashCardResponseVo.setCashCardName(cashCardResponseDo.getCashCardName());
				cashCardResponseVo.setCashCardStatus(cashCardResponseDo.getCardStatus());
				cashCardResponseVo.setAccountNumber(cashCardResponseDo.getAccountNumber());
				List<UserVo> contributors = new ArrayList<UserVo>();
				UserVo userVo = new UserVo();
				userVo.setPayerNumber(cashCardResponseDo.getPayerSiNumber());
				userVo.setRequestStatus(cashCardResponseDo.getRequestStatus());
				userVo.setRequestedAmount(cashCardResponseDo.getMaxRequestedAmountFromPayer());
				userVo.setRequestId(cashCardResponseDo.getRequestId());
				userVo.setReceivedAmount(cashCardResponseDo.getReceivedAmount());
				contributors.add(userVo);
				cashCardResponseVo.setContributors(contributors);
				giftIdPresentMap.put(cashCardResponseDo.getCashCardId(), "PRESENT");
				cashCardResponseVos.add(cashCardResponseVo);
			}else{
				for(CashCardResponseVo cashCardResponseVoIter : cashCardResponseVos){
					if(cashCardResponseVoIter.getCashCardId().equals(cashCardResponseDo.getCashCardId())){
						cashCardResponseVo = cashCardResponseVoIter;
						break;
					}
				}
				UserVo userVo = new UserVo();
				userVo.setPayerNumber(cashCardResponseDo.getPayerSiNumber());
				userVo.setRequestStatus(cashCardResponseDo.getRequestStatus());
				userVo.setRequestedAmount(cashCardResponseDo.getMaxRequestedAmountFromPayer());
				userVo.setRequestId(cashCardResponseDo.getRequestId());
				userVo.setReceivedAmount(cashCardResponseDo.getReceivedAmount());
				List<UserVo> userVos = cashCardResponseVo.getContributors();
				if(userVos != null){
					userVos.add(userVo);
				}else{
					userVos = Arrays.asList(userVo);
				}
				cashCardResponseVo.setContributors(userVos);
			}
		}
		return cashCardResponseVos;
	}
}
