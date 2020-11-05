package br.com.dashboardlejour.bean;

public class Invoice {
	private String ID;
	private String WEDDING_ID;
	private String VENDOR_ID;
	private String AMOUNT;
	private String VENDOR_AMOUNT;
	private String ACCEPTED;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}

	public String getWEDDING_ID() {
		return WEDDING_ID;
	}

	public void setWEDDING_ID(String wEDDING_ID) {
		WEDDING_ID = wEDDING_ID;
	}

	public String getVENDOR_ID() {
		return VENDOR_ID;
	}

	public void setVENDOR_ID(String vENDOR_ID) {
		VENDOR_ID = vENDOR_ID;
	}

	public String getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(String aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public String getVENDOR_AMOUNT() {
		return VENDOR_AMOUNT;
	}

	public void setVENDOR_AMOUNT(String vENDOR_AMOUNT) {
		VENDOR_AMOUNT = vENDOR_AMOUNT;
	}

	public String getACCEPTED() {
		return ACCEPTED;
	}

	public void setACCEPTED(String aCCEPTED) {
		ACCEPTED = aCCEPTED;
	}
	
	@Override
	public String toString() {
		return "[ID = "+ ID 
				+ ", WEDDING_ID = "+ WEDDING_ID 
				+ ", VENDOR_ID = "+ VENDOR_ID
				+ ", AMOUNT = "+ AMOUNT
				+ ", VENDOR_AMOUNT = "+ VENDOR_AMOUNT
				+", ACCEPTED = "+ ACCEPTED +"]";
		
	}
}
