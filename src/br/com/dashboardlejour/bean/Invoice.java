package br.com.dashboardlejour.bean;

public class Invoice {
	private String ID;
	private String WEDDING_ID;
	private String VENDOR_ID;
	private String AMOUNT;
	private String VENDOR_AMOUNT;
	private String ACCEPTED;
	
	public int getID() {
		return Integer.parseInt(ID);
	}
	
	public void setID(int iD) {
		ID = Integer.toString(iD);
	}

	public int getWEDDING_ID() {
		return Integer.parseInt(WEDDING_ID);
	}

	public void setWEDDING_ID(int wEDDING_ID) {
		WEDDING_ID = Integer.toString(wEDDING_ID);
	}

	public int getVENDOR_ID() {
		return Integer.parseInt(VENDOR_ID);
	}

	public void setVENDOR_ID(int vENDOR_ID) {
		VENDOR_ID = Integer.toString(vENDOR_ID);
	}

	public double getAMOUNT() {
		return Double.parseDouble(AMOUNT);
	}

	public void setAMOUNT(double aMOUNT) {
		AMOUNT = Double.toString(aMOUNT);
	}

	public double getVENDOR_AMOUNT() {
		return Double.parseDouble(VENDOR_AMOUNT);
	}

	public void setVENDOR_AMOUNT(double vENDOR_AMOUNT) {
		VENDOR_AMOUNT = Double.toString(vENDOR_AMOUNT);
	}

	public boolean getACCEPTED() {
		return Boolean.parseBoolean(ACCEPTED);
	}

	public void setACCEPTED(boolean aCCEPTED) {
		ACCEPTED = Boolean.toString(aCCEPTED);
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
