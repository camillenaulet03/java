package fr.imie.bank.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static final DateTimeFormatter fr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static LocalDate toDate(String text) {
		
		LocalDate dateObj = (text==null || text.isEmpty()) ?  null : LocalDate.parse(text, fr);
		return dateObj;
        
	}

	public static String toString(LocalDate date) {
		String dateS = ( date == null ) ? null : date.format(fr);
		
		return dateS;
	}
}