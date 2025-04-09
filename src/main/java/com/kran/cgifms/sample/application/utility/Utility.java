package com.kran.cgifms.sample.application.utility;

import java.time.LocalDate;

public class Utility {

	public String getCurrentFinancialYear() {
	    LocalDate today = LocalDate.now();
	    int currentYear = today.getYear();
	    int currentMonth = today.getMonthValue();
	    int startYear = (currentMonth < 4) ? currentYear - 1 : currentYear;
	    int endYear = startYear + 1;
	    
	    return startYear + "-" + String.format("%02d", endYear % 100);
	}
}
