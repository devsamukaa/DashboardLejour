package br.com.dashboardlejour.business;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import br.com.dashboardlejour.helpers.DateHelper;

public class BusinessParams {
	
	private Date dateFrom;
	private Date dateUntil;
	private String year;
	private String weddingType;
	private Double budget;
	private String sortBy;
	private String order;
	
	public BusinessParams() {
		
	}
	
	public BusinessParams(Date dateFrom, Date dateUntil, String year, String weddingType, Double budget, String sortBy, String order) {
		this.dateFrom = dateFrom;
		this.dateUntil = dateUntil;
		this.year = year;
		this.weddingType = weddingType;
		this.budget = budget;
		this.sortBy = sortBy;
		this.order = order;
	}
	
	public BusinessParams(HttpServletRequest request) {
		
		Enumeration<String> parameterNames = request.getParameterNames();
		 
        while (parameterNames.hasMoreElements()) {
        	
            String paramName = parameterNames.nextElement();
  
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
            	
            	String paramValue = paramValues[i];
            	
            	if(paramName.equals("data_de")) {
            		
            		this.dateFrom = DateHelper.parseDate(paramValue);
                	
                } else if (paramName.equals("data_ate")) {
                	
                	this.dateUntil = DateHelper.parseDate(paramValue);
                	
                } else if (paramName.equals("ano")) {
                	
                	this.year = paramValue;
                	
                } else if (paramName.equals("estilo")) {
                	
                	this.weddingType = paramValue;
                	
                } else if (paramName.equals("budget")) {
                	
                	this.budget = Double.parseDouble(paramValue);
                	
                } else if (paramName.equals("ordernar_por")) {
                	
                	this.sortBy = paramValue;
                	
                } else if (paramName.equals("ordem")) {
                	
                	this.order = paramValue;
                	
                }
            	
            }
            
        }
		
	}
	
	public Date getDateFrom() {
		return dateFrom;
	}
	
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(Date dateUntil) {
		this.dateUntil = dateUntil;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWeddingType() {
		return weddingType;
	}

	public void setWeddingType(String weddingType) {
		this.weddingType = weddingType;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
}
