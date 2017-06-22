package com.airtel.online.cash.card.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.airtel.online.cash.card.utils.CashCardUtil;
import com.airtel.online.cash.card.vo.CashCardTransactionDo;
import com.airtel.online.cash.card.vo.CashCardTransactionVo;

@Component
public class CashCardTransactionDoToCashCardTransactionVoConverter {

	public List<CashCardTransactionVo> convert(List<CashCardTransactionDo> cashCardTransactionDos){
		if(CashCardUtil.isEmpty(cashCardTransactionDos)){
			return null;
		}
		List<CashCardTransactionVo> cashCardTransactionVos = new ArrayList<>();
		for(CashCardTransactionDo cashCardTransactionDo : cashCardTransactionDos){
			CashCardTransactionVo cashCardTransactionVo = new CashCardTransactionVo();
			cashCardTransactionVo.setGiftId(cashCardTransactionDo.getGiftId());
			cashCardTransactionVo.setMsisdn(cashCardTransactionDo.getMsisdn());
			cashCardTransactionVo.setPayer(cashCardTransactionDo.getPayer());
			cashCardTransactionVo.setRecvAmount(cashCardTransactionDo.getRecvAmount());
			cashCardTransactionVo.setReqAmount(cashCardTransactionDo.getReqAmount());
			cashCardTransactionVo.setRequestId(cashCardTransactionDo.getRequestId());
			cashCardTransactionVo.setStatus(cashCardTransactionDo.getStatus());
			cashCardTransactionVo.setTime(CashCardUtil.convertTimestampToFormattedDate(cashCardTransactionDo.getTime()));
			cashCardTransactionVos.add(cashCardTransactionVo);
		}
		return cashCardTransactionVos;
	}
}
