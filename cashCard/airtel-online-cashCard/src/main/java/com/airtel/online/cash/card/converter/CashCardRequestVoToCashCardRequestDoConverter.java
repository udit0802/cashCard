package com.airtel.online.cash.card.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.airtel.online.cash.card.vo.CashCardRequestDo;
import com.airtel.online.cash.card.vo.CashCardRequestVo;

@Component
public class CashCardRequestVoToCashCardRequestDoConverter {
	
	@Value("${cash.card.validity}")
	private String cashCardValidity;
	
	public CashCardRequestDo convert(CashCardRequestVo cashCardRequestVo){
		CashCardRequestDo cashCardRequestDo = new CashCardRequestDo();
		cashCardRequestDo.setCashCardId(cashCardRequestVo.getCashCardId());
		cashCardRequestDo.setCashCardOwner(cashCardRequestVo.getCashCardOwner());
		cashCardRequestDo.setValidity(Integer.parseInt(cashCardValidity));
		cashCardRequestDo.setEmail(cashCardRequestVo.getEmailId());
		cashCardRequestDo.setCashCardName(cashCardRequestVo.getCashCardName());
		cashCardRequestDo.setAccountNumber(cashCardRequestVo.getAccountNumber());
		cashCardRequestDo.setRequestedAmount(cashCardRequestVo.getTotalRequestedAmount());
		return cashCardRequestDo;
	}
}
