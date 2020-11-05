package br.com.dashboardlejour.bean;

public class Appointment {
	
	private String ID;
	private String WEDDING_ID;
	private String VENDOR_ID;
	private String STATUS;
	private String VENDOR_CATEGORY;
	
	
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
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getVENDOR_CATEGORY() {
		return VENDOR_CATEGORY;
	}
	public void setVENDOR_CATEGORY(String vENDOR_CATEGORY) {
		VENDOR_CATEGORY = vENDOR_CATEGORY;
	}
	@Override
	public String toString() {
		return "Appointment [ID=" + ID 
				+ ", WEDDING_ID=" + WEDDING_ID 
				+ ", VENDOR_ID=" + VENDOR_ID 
				+ ", STATUS="+ STATUS 
				+ ", VENDOR_CATEGORY=" + VENDOR_CATEGORY + "]";
	}
	
		

}



