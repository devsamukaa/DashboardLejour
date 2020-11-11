package br.com.dashboardlejour.bean;

import java.io.Serializable;

public class Wedding implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String OWNER_ID;
	private String BUDGET;
	private String WEDDING_DATE;
	private String NUMBER_OF_GUESTS;
	private String STYLE;
	
	public int getID() {
		return Integer.parseInt(ID);
	}
	
	public void setID(int iD) {
		ID = Integer.toString(iD);
	}
	
	public int getOWNER_ID() {
		return Integer.parseInt(OWNER_ID);
	}
	
	public void setOWNER_ID(int oWNER_ID) {
		OWNER_ID = Integer.toString(oWNER_ID);
	}
	
	public double getBUDGET() {
		
		if (BUDGET.equals("NULL")) {
			return 0;
		} else {
			return Double.parseDouble(BUDGET);
		}
		
	}
	
	public void setBUDGET(double bUDGET) {
		BUDGET = Double.toString(bUDGET);
	}

	public String getWEDDING_DATE() {
		return WEDDING_DATE;
	}

	public void setWEDDING_DATE(String wEDDING_DATE) {
		WEDDING_DATE = wEDDING_DATE;
	}
	
	public void setNUMBER_OF_GUESTS(int nUMBER_OF_GUESTS) {
		WEDDING_DATE = Integer.toString(nUMBER_OF_GUESTS);
	}

	public int getNUMBER_OF_GUESTS() {
		return Integer.parseInt(NUMBER_OF_GUESTS);
	}

	public String getSTYLE() {
		return STYLE;
	}

	public void setSTYLE(String sTYLE) {
		STYLE = sTYLE;
	}
	
	
	@Override
	public String toString() {
		return "[ID = "+ ID 
				+ ", OWNER_ID = "+ OWNER_ID 
				+ ", BUDGET = "+ BUDGET 
				+ ", WEDDING_DATE = "+ WEDDING_DATE
				+ ", NUMBER_OF_GUESTS = "+ NUMBER_OF_GUESTS
				+", STYLE = "+ STYLE +"]";
		
	}
	
}
