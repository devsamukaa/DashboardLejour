package br.com.dashboardlejour.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.dashboardlejour.bean.Wedding;
import br.com.dashboardlejour.helpers.DateHelper;
import br.com.dashboardlejour.service.WeddingService;

public class BusinessHigherBudgetWeddings {
	
	private String weddingType;
	private int weddings;
	
	public BusinessHigherBudgetWeddings() {
		
	}
	
	public BusinessHigherBudgetWeddings(String weddingType, int weddings) {
		
		this.weddingType = weddingType;
		this.weddings = weddings;
		
	}
	
	public String getWeddingType() {
		return weddingType;
	}
	
	public void setWeddingType(String weddingType) {
		this.weddingType = weddingType;
	}

	public int getWeddings() {
		return weddings;
	}

	public void setWeddings(int weddings) {
		this.weddings = weddings;
	}
	
	public List<BusinessHigherBudgetWeddings> getWeddingsWithBudgetOverX(BusinessParams params) {
		
		Boolean filterFlagDate = params.getDateFrom() != null && params.getDateUntil() != null;
		Boolean filterFlagBudget = params.getBudget() != null;
		
		List<BusinessHigherBudgetWeddings> list = this.getResetedListWeddingsWithBudgetOverX();
		
		WeddingService service = new WeddingService();
		
		List<Wedding> weddingsList = service.getAll();
		
		for (Wedding wedding : weddingsList) {
			
			int listIndex = -1;
			
			if(wedding.getSTYLE().equals("classico")) {
				
				listIndex = 0;
				
			} else if(wedding.getSTYLE().equals("rustico")) {
				
				listIndex = 1;
				
			} else if(wedding.getSTYLE().equals("moderno")) {
				
				listIndex = 2;
				
			}
			
			//Obtendo a data para poder obter o mês;
			Date weddingDate = DateHelper.parseDate(wedding.getWEDDING_DATE());
			
			//Verificando se a data está vazia. Se sim, atruibuo a contagem para casamentos sem data
			if(weddingDate == null) {
				
				if(filterFlagBudget) {
						
					if(wedding.getBUDGET() >= params.getBudget()) {
						
						BusinessHigherBudgetWeddings lastValue = null;
						lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
						
					}		
					
				}
				
			} else if(weddingDate != null) {
			//Se a data estiver preenchida, atribuo a contagem para o mês correto
				
				//Instanciando Calendário para trabalhar com as datas
				Calendar calendar = new GregorianCalendar();
		        calendar.setLenient(false);
				calendar.setTimeInMillis(weddingDate.getTime());
				
				if(filterFlagDate && filterFlagBudget) {
					
					if(weddingDate.after(params.getDateFrom()) && weddingDate.before(params.getDateUntil()) && wedding.getBUDGET() >= params.getBudget()) {
						
						BusinessHigherBudgetWeddings lastValue = null;
						lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
						
					}
					
				} else if(filterFlagBudget) {
					
					if(wedding.getBUDGET() >= params.getBudget()) {
						
						BusinessHigherBudgetWeddings lastValue = null;
						lastValue = list.get(listIndex);
						lastValue = this.IncrementWedding(lastValue);
						list.set(listIndex, lastValue);
						
					}		
					
				}
			}
		}
		
		return list;
		
	}
	
	public BusinessHigherBudgetWeddings IncrementWedding(BusinessHigherBudgetWeddings lastValue) {
		
		BusinessHigherBudgetWeddings newValue = lastValue;
		newValue.setWeddings(lastValue.weddings + 1);
		return newValue;
		
	}
	
	public List<BusinessHigherBudgetWeddings> getResetedListWeddingsWithBudgetOverX() {
		
		List<BusinessHigherBudgetWeddings> list = new ArrayList<BusinessHigherBudgetWeddings>();
		
		list.add(new BusinessHigherBudgetWeddings("classico", 0));
		list.add(new BusinessHigherBudgetWeddings("rustico", 0));
		list.add(new BusinessHigherBudgetWeddings("moderno", 0));
		
		return list;
	}
	
	@Override
	public String toString() {
		return "[weddingType = "+ weddingType 
				+", weddings = "+ weddings +"]";
		
	}
	
}
