package br.com.dashboardlejour.bean;

import java.io.Serializable;

public class VendorFavorited implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String wedding_id;
	private String vendor_id;
	
	public int getWeeding_id() {
		return Integer.parseInt(wedding_id);
	}
	
	public void setWeeding_id(int wedding_id) {
		this.wedding_id = Integer.toString(wedding_id);
	}

	public int getVendor_id() {
		return Integer.parseInt(vendor_id);
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = Integer.toString(vendor_id);
	}
	
	@Override
	public String toString() {
		return "[wedding_id = "+ wedding_id 
				+", vendor_id = "+ vendor_id +"]";
		
	}
}
