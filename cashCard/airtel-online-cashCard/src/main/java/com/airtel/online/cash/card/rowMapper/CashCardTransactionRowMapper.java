package com.airtel.online.cash.card.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.airtel.online.cash.card.vo.CashCardTransactionDo;

@Component
public class CashCardTransactionRowMapper implements RowMapper<CashCardTransactionDo> {

	@Override
	public CashCardTransactionDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CashCardTransactionDo cardTransactionDo = new CashCardTransactionDo();
		cardTransactionDo.setMsisdn(rs.getString("MSISDN"));
		cardTransactionDo.setRequestId(rs.getString("REQUEST_ID"));
		cardTransactionDo.setReqAmount(rs.getString("MAX_REQ_AMOUNT"));
		cardTransactionDo.setStatus(rs.getString("REQUEST_STATUS"));
		cardTransactionDo.setPayer(rs.getString("PAYER"));
		cardTransactionDo.setTime(rs.getTimestamp("TIME"));
		cardTransactionDo.setGiftId(rs.getString("GIFT_ID"));
		cardTransactionDo.setRecvAmount(rs.getString("RECV_AMOUNT"));
		return cardTransactionDo;
	}

}
