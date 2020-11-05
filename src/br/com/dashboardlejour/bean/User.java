package br.com.dashboardlejour.bean;

public class User {
	
	
	private String ID;
	private String CREATED_AT;
	
	
	public int getID() {
		return Integer.parseInt(ID);
	}
	public void setID(int iD) {
		ID = Integer.toString(iD);
	}
	public String getCREATED_AT() {
		return CREATED_AT;
	}

	public void setCREATED_AT(String cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", CREATED_AT=" + CREATED_AT + "]";
	}
	
	

}
