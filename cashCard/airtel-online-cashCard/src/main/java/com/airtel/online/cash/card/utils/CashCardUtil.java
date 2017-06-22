package com.airtel.online.cash.card.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.airtel.online.cash.card.constants.CashCardConstants;
import com.airtel.online.cash.card.vo.MyAirtelAppResponseVo;
import com.airtel.online.cash.card.vo.ResponseVo;

public class CashCardUtil {
	
	public static String convertTimestampToFormattedDate(Timestamp timestamp){
		Date date = new Date();
		date.setTime(timestamp.getTime());
		return (new SimpleDateFormat(CashCardConstants.DATE_FORMAT).format(date));
	}
	
	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.isEmpty();
	}
}
