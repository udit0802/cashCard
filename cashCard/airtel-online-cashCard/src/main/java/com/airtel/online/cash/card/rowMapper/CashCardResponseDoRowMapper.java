package com.airtel.online.cash.card.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.airtel.online.cash.card.vo.CashCardResponseDo;

@Component
public class CashCardResponseDoRowMapper implements RowMapper<CashCardResponseDo> {

	@Override
	public CashCardResponseDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CashCardResponseDo cashCardResponseDo = new CashCardResponseDo();
		cashCardResponseDo.setCashCardId(rs.getString("CASH_CARD_ID"));
		cashCardResponseDo.setCardRequestDate(rs.getTimestamp("REQUEST_DATE"));
		cashCardResponseDo.setEmail(rs.getString("EMAIL"));
		cashCardResponseDo.setReqAmount(rs.getString("REQ_AMOUNT"));
		cashCardResponseDo.setCashCardName(rs.getString("CASH_CARD_NAME"));
		cashCardResponseDo.setCardStatus(rs.getString("STATUS"));
		cashCardResponseDo.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		cashCardResponseDo.setPayerSiNumber(rs.getString("PAYER"));
		cashCardResponseDo.setRequestId(rs.getString("REQUEST_ID"));
		cashCardResponseDo.setMaxRequestedAmountFromPayer(rs.getString("REQUEST_ID"));
		cashCardResponseDo.setRequestStatus(rs.getString("REQUEST_STATUS"));
		cashCardResponseDo.setReceivedAmount(rs.getString("RECV_AMOUNT"));
		return cashCardResponseDo;
	}

}
