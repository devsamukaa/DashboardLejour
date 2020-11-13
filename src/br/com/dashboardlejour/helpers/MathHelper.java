package br.com.dashboardlejour.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MathHelper {
	
	public static double round(double doubleValue) {
		
		doubleValue = Math.floor(doubleValue * 100) / 100;
		
		return doubleValue;
		
	}
}
