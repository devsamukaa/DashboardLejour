package br.com.dashboardlejour.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.dashboardlejour.bean.Appointment;
import br.com.dashboardlejour.bean.Invoice;
import br.com.dashboardlejour.bean.VendorFavorited;
import br.com.dashboardlejour.bean.Wedding;
import br.com.dashboardlejour.helpers.DateHelper;
import br.com.dashboardlejour.service.AppointmentService;
import br.com.dashboardlejour.service.InvoiceService;
import br.com.dashboardlejour.service.VendorFavoritedService;
import br.com.dashboardlejour.service.WeddingService;

public class BusinessWeddingStatus {
	
	private String status;
	private int weddings;
	
	public BusinessWeddingStatus() {
		
	}
	
	public BusinessWeddingStatus( String status, int weddings) {
		this.status = status;
		this.weddings = weddings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWeddings() {
		return weddings;
	}

	public void setWeddings(int weddings) {
		this.weddings = weddings;
	}
	
	private boolean verifyWeddingIfInVendorFavoriteList(Wedding wedding, List<VendorFavorited> vendorFavoritedList) {
        for (int i = 0; i < vendorFavoritedList.size(); i++) {
            if (vendorFavoritedList.get(i) !=null && vendorFavoritedList.get(i).getWeeding_id() == wedding.getID()) {
                return true;
            }
        }
        return false;// not there is list
    }
	
	private boolean verifyWeddingIfInAppointmentList(Wedding wedding, List<Appointment> appointmentList) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i) !=null && appointmentList.get(i).getWEDDING_ID() == wedding.getID()) {
                return true;
            }
        }
        return false;// not there is list
    }
	
	private boolean verifyWeddingIfInInvoiceList(Wedding wedding, List<Invoice> invoiceList) {
        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i) !=null && invoiceList.get(i).getWEDDING_ID() == wedding.getID()) {
                return true;
            }
        }
        return false;// not there is list
    }
	
	public List<BusinessWeddingStatus> getWeddingStatus(){
			
		List<BusinessWeddingStatus> list = this.getResetedListWeddingStatus();
			
		WeddingService service = new WeddingService();
		VendorFavoritedService vendor = new VendorFavoritedService();
		AppointmentService appointment = new AppointmentService();
		InvoiceService invoice = new InvoiceService();
				
		List<Wedding> weddingsList = service.getAll();
		List<VendorFavorited> vendorsList = vendor.getAll();
		List<Appointment> appointmentList = appointment.getAll();
		List<Invoice> invoicesList = invoice.getAll();

		for(Wedding wedding : weddingsList) {
			int listIndex = -1;
			
			if(verifyWeddingIfInInvoiceList(wedding, invoicesList)) {
				
				listIndex = 3;
				
			} else if(verifyWeddingIfInAppointmentList(wedding, appointmentList)) {
				
				listIndex = 2;
				
			} else if(verifyWeddingIfInVendorFavoriteList(wedding, vendorsList)) {
				
				listIndex = 1;
				
			}else {
				listIndex = 0;
			}
			BusinessWeddingStatus lastValue = null;
			lastValue = list.get(listIndex);
			lastValue = this.IncrementWedding(lastValue);
			list.set(listIndex, lastValue);
		}
			
		return list;
	}
	
	public List<BusinessWeddingStatus> getWeddingStatus(BusinessParams params){
		
		Boolean filterFlagDate = params.getDateFrom() != null && params.getDateUntil() != null;
		Boolean filterFlagWeddingStyle = params.getWeddingType() != null;
		
		List<BusinessWeddingStatus> list = this.getResetedListWeddingStatus();
			
		WeddingService service = new WeddingService();
		VendorFavoritedService vendor = new VendorFavoritedService();
		AppointmentService appointment = new AppointmentService();
		InvoiceService invoice = new InvoiceService();
				
		List<Wedding> weddingsList = service.getAll();
		List<VendorFavorited> vendorsList = vendor.getAll();
		List<Appointment> appointmentList = appointment.getAll();
		List<Invoice> invoicesList = invoice.getAll();

		for(Wedding wedding : weddingsList) {
			int listIndex = -1;
			
			if(verifyWeddingIfInInvoiceList(wedding, invoicesList)) {
				
				listIndex = 3;
				
			} else if(verifyWeddingIfInAppointmentList(wedding, appointmentList)) {
				
				listIndex = 2;
				
			} else if(verifyWeddingIfInVendorFavoriteList(wedding, vendorsList)) {
				
				listIndex = 1;
				
			}else {
				listIndex = 0;
			}
			
			//Obtendo a data para poder obter o m�s;
			Date weddingDate = DateHelper.parseDate(wedding.getWEDDING_DATE());
			
			//Verificando se a data est� vazia. Se sim, atruibuo a contagem para casamentos sem data
			if(weddingDate == null && !filterFlagDate) {
				if(filterFlagWeddingStyle) {
					if(wedding.getSTYLE().equals(params.getWeddingType())) {
						BusinessWeddingStatus lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
					}	
				}
				
			} else if(weddingDate != null) {
				if(filterFlagDate && filterFlagWeddingStyle) {
					
					if(weddingDate.after(params.getDateFrom()) && weddingDate.before(params.getDateUntil()) && wedding.getSTYLE().equals(params.getWeddingType())) {
						
						BusinessWeddingStatus lastValue = null;
						lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
						
					}
				}else if(filterFlagDate) {
					if(weddingDate.after(params.getDateFrom()) && weddingDate.before(params.getDateUntil())) {
						
						BusinessWeddingStatus lastValue = null;
						lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
						
					}

				}else if(filterFlagWeddingStyle) {
					if(wedding.getSTYLE().equals(params.getWeddingType())) {
						
						BusinessWeddingStatus lastValue = null;
						lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
						
					}

				}
			}
			
		}
			
		return list;
	}
	
	public BusinessWeddingStatus IncrementWedding(BusinessWeddingStatus lastValue) {
		
		BusinessWeddingStatus newValue = lastValue;
		newValue.setWeddings(lastValue.weddings + 1);
		return newValue;
		
	}
				
	
	public List<BusinessWeddingStatus> getResetedListWeddingStatus() {
		
		List<BusinessWeddingStatus> list = new ArrayList<BusinessWeddingStatus>();
		
		list.add(new BusinessWeddingStatus("criado", 0));
		list.add(new BusinessWeddingStatus("em_pesquisa", 0));
		list.add(new BusinessWeddingStatus("em_agendamento", 0));
		list.add(new BusinessWeddingStatus("em_pagamento", 0));

		
		return list;
	}

	@Override
	public String toString() {
		return "[status=" + status
				+ ", weddings=" + weddings + "]";
	}
	
	
}
