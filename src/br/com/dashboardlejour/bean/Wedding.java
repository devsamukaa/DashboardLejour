package br.com.dashboardlejour.bean;

public class Wedding {
	private String ID;
	private String OWNER_ID;
	private String WEDDING_DATE;
	private String NUMBER_OF_GUESTS;
	private String STYLE;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getOWNER_ID() {
		return OWNER_ID;
	}
	
	public void setOWNER_ID(String oWNER_ID) {
		OWNER_ID = oWNER_ID;
	}

	public String getWEDDING_DATE() {
		return WEDDING_DATE;
	}

	public void setWEDDING_DATE(String wEDDING_DATE) {
		WEDDING_DATE = wEDDING_DATE;
	}

	public String getNUMBER_OF_GUESTS() {
		return NUMBER_OF_GUESTS;
	}

	public void setNUMBER_OF_GUESTS(String nUMBER_OF_GUESTS) {
		NUMBER_OF_GUESTS = nUMBER_OF_GUESTS;
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
				+ ", WEDDING_DATE = "+ WEDDING_DATE
				+ ", NUMBER_OF_GUESTS = "+ NUMBER_OF_GUESTS
				+", STYLE = "+ STYLE +"]";
		
	}
	
}
