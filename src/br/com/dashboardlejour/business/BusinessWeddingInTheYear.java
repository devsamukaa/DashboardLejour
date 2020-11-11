package br.com.dashboardlejour.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.dashboardlejour.bean.Wedding;
import br.com.dashboardlejour.helpers.DateHelper;
import br.com.dashboardlejour.service.WeddingService;
import br.com.dashboardlejour.business.BusinessWeddingInTheYear;

public class BusinessWeddingInTheYear {
	
	private String month;
	private int weddings;
	
	public BusinessWeddingInTheYear() {
		
	}
	
	public BusinessWeddingInTheYear(String month, int weddings) {
		this.month = month;
		this.weddings = weddings;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}

	public int getWeddings() {
		return weddings;
	}

	public void setWeddings(int weddings) {
		this.weddings = weddings;
	}
	
	public List<BusinessWeddingInTheYear> getWeddingsInTheYear() {
		
		List<BusinessWeddingInTheYear> list = this.getResetedListWeddingsInTheYear();
		
		WeddingService service = new WeddingService();
		
		List<Wedding> weddingsList = service.getAll();
		
		for (Wedding wedding : weddingsList) {
			
			//Obtendo a data para poder obter o mês;
			Date weddingDate = DateHelper.parseDate(wedding.getWEDDING_DATE());
			
			//Verificando se a data está vazia. Se sim, atruibuo a contagem para casamentos sem data
			if(weddingDate == null) {
				
				BusinessWeddingInTheYear lastValue = list.get(12);
				lastValue = this.IncrementWedding(lastValue);
				list.set(12, lastValue);
			
			
			} else {
			//Se a data estiver preenchida, atribuo a contagem para o mês correto
				Calendar calendar = new GregorianCalendar();
		        calendar.setLenient(false);
		        calendar.setTimeInMillis(weddingDate.getTime());
		        
		        int monthIndex = calendar.get(Calendar.MONTH);
		        
		        BusinessWeddingInTheYear lastValue = list.get(monthIndex);
				lastValue = this.IncrementWedding(lastValue);
		        list.set(monthIndex, lastValue);
				
			}
			
		}
		
		return list;
	}
	
	public List<BusinessWeddingInTheYear> getWeddingsInTheYear(BusinessParams params) {
		
		Boolean filterFlagYear = params.getYear() != null;
		Boolean filterFlagWeddingType = params.getWeddingType() != null;
		
		if(filterFlagYear) {
			params.setDateFrom(DateHelper.parseDate("01/01/"+params.getYear()+" 00:00:00"));
			params.setDateUntil(DateHelper.parseDate("31/12/"+params.getYear()+" 23:59:59"));
		}
		
		List<BusinessWeddingInTheYear> list = this.getResetedListWeddingsInTheYear();
		
		WeddingService service = new WeddingService();
		
		List<Wedding> weddingsList = service.getAll();
		
		for (Wedding wedding : weddingsList) {
			
			//Obtendo a data para poder obter o mês;
			Date weddingDate = DateHelper.parseDate(wedding.getWEDDING_DATE());
			
			//Verificando se a data está vazia. Se sim, atruibuo a contagem para casamentos sem data
			if(weddingDate == null) {
				
				if(filterFlagWeddingType) {
						
					if(wedding.getSTYLE().equals(params.getWeddingType())) {
						BusinessWeddingInTheYear lastValue = list.get(12);
						lastValue = this.IncrementWedding(lastValue);
						list.set(12, lastValue);
					}		
					
				} else {
					
					BusinessWeddingInTheYear lastValue = list.get(12);
					lastValue = this.IncrementWedding(lastValue);
					list.set(12, lastValue);
					
				}
					
			} else {
			//Se a data estiver preenchida, atribuo a contagem para o mês correto
				
				//Instanciando Calendário para trabalhar com as datas
				Calendar calendar = new GregorianCalendar();
		        calendar.setLenient(false);
				calendar.setTimeInMillis(weddingDate.getTime());
				int monthIndex = calendar.get(Calendar.MONTH);
				
				if(filterFlagYear && filterFlagWeddingType) {
					
					if(weddingDate.after(params.getDateFrom()) && weddingDate.before(params.getDateUntil()) && wedding.getSTYLE().equals(params.getWeddingType())) {
						BusinessWeddingInTheYear lastValue = list.get(monthIndex);
						lastValue = this.IncrementWedding(lastValue);
				        list.set(monthIndex, lastValue);
					}
					
				} else if (filterFlagYear) {
					
					if(weddingDate.after(params.getDateFrom()) && weddingDate.before(params.getDateUntil())) {
						BusinessWeddingInTheYear lastValue = list.get(monthIndex);
						lastValue = this.IncrementWedding(lastValue);
				        list.set(monthIndex, lastValue);
					}
					
				} else if (filterFlagWeddingType) {
					
					if(wedding.getSTYLE().equals(params.getWeddingType())) {
						BusinessWeddingInTheYear lastValue = list.get(monthIndex);
						lastValue = this.IncrementWedding(lastValue);
				        list.set(monthIndex, lastValue);
					}		
				}
			}
		}
		
		return list;
		
	}
	
	public BusinessWeddingInTheYear IncrementWedding(BusinessWeddingInTheYear lastValue) {
		
		BusinessWeddingInTheYear newValue = lastValue;
		
		newValue.setWeddings(lastValue.weddings + 1);
		
		return newValue;
		
	}
	
	public List<BusinessWeddingInTheYear> getResetedListWeddingsInTheYear() {
		
		List<BusinessWeddingInTheYear> list = new ArrayList<BusinessWeddingInTheYear>();
		
		list.add(new BusinessWeddingInTheYear("Jan", 0));
		list.add(new BusinessWeddingInTheYear("Fev", 0));
		list.add(new BusinessWeddingInTheYear("Mar", 0));
		list.add(new BusinessWeddingInTheYear("Abr", 0));
		list.add(new BusinessWeddingInTheYear("Mai", 0));
		list.add(new BusinessWeddingInTheYear("Jun", 0));
		list.add(new BusinessWeddingInTheYear("Jul", 0));
		list.add(new BusinessWeddingInTheYear("Ago", 0));
		list.add(new BusinessWeddingInTheYear("Set", 0));
		list.add(new BusinessWeddingInTheYear("Out", 0));
		list.add(new BusinessWeddingInTheYear("Nov", 0));
		list.add(new BusinessWeddingInTheYear("Dez", 0));
		list.add(new BusinessWeddingInTheYear("s_data", 0));
		
		return list;
	}
	
	@Override
	public String toString() {
		return "[month = "+ month 
				+", weddings = "+ weddings +"]";
		
	}
	
}
