package br.com.dashboardlejour.bean;

import java.io.Serializable;

public class VendorFavorited implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String wedding_id;
	private String vendor_id;
	
	public String getWeeding_id() {
		return wedding_id;
	}
	
	public void setWeeding_id(String wedding_id) {
		this.wedding_id = wedding_id;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	
	@Override
	public String toString() {
		return "[wedding_id = "+ wedding_id 
				+", vendor_id = "+ vendor_id +"]";
		
	}
}
