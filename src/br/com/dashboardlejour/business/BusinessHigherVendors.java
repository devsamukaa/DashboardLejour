package br.com.dashboardlejour.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.dashboardlejour.bean.Invoice;
import br.com.dashboardlejour.bean.Wedding;
import br.com.dashboardlejour.helpers.DateHelper;
import br.com.dashboardlejour.helpers.MathHelper;
import br.com.dashboardlejour.service.InvoiceService;
import br.com.dashboardlejour.service.WeddingService;
import sorter.BusinessHigherVendorsSorter;

public class BusinessHigherVendors {
	
	private int vendorId;
	private double totalAmount;
	private double totalVendorAmount;
	private double totalProfit;
	private double profitMargin;
	private int acceptedInvoices;
	private int declinedInvoices;
	
	public BusinessHigherVendors() {
		
	}
	
	public BusinessHigherVendors(int vendorId, double totalAmount, double totalVendorAmount, double totalProfit, double profitMargin, int accepteInvoices, int declinedInvoices) {
		this.vendorId = vendorId;
		this.totalAmount = totalAmount;
		this.totalVendorAmount = totalVendorAmount;
		this.totalProfit = totalProfit;
		this.profitMargin = profitMargin;
		this.acceptedInvoices = accepteInvoices;
		this.declinedInvoices = declinedInvoices;
	}
	
	public int getVendorId() {
		return vendorId;
	}
	
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTotalVendorAmount() {
		return totalVendorAmount;
	}

	public void setTotalVendorAmount(double totalVendorAmount) {
		this.totalVendorAmount = totalVendorAmount;
	}

	public double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public double getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(double profitMargin) {
		this.profitMargin = profitMargin;
	}

	public int getAcceptedInvoices() {
		return acceptedInvoices;
	}

	public void setAcceptedInvoices(int accepteInvoices) {
		this.acceptedInvoices = accepteInvoices;
	}

	public int getDeclinedInvoices() {
		return declinedInvoices;
	}

	public void setDeclinedInvoices(int declinedInvoices) {
		this.declinedInvoices = declinedInvoices;
	}
	
	public List<BusinessHigherVendors> getHigherVendors() {
		
		List<BusinessHigherVendors> listHigherVendors = new ArrayList<BusinessHigherVendors>();
		
		InvoiceService invoiceService = new InvoiceService();
		List<Invoice> invoiceList = invoiceService.getAll();
		
		//Percorrendo invoices para montar a lista de fornecedores rentáveis
		for (Invoice invoice : invoiceList) {
			
			//Guardando ID do fornecedor, para incrementar os valores e reatribuir na mesma posição da lista
			int indexVendorInHigherVendorList = getIndexVendorInHigherVendorList(invoice.getVENDOR_ID(), listHigherVendors);
			
			InsertNewOrIncrementVendor(indexVendorInHigherVendorList, listHigherVendors, invoice);
				
		}
		
		BusinessHigherVendorsSorter BHVSorter = new BusinessHigherVendorsSorter(listHigherVendors);
		
		return BHVSorter.getSortedHigherVendorsByProfitMarginDesc();
	}
	
	public List<BusinessHigherVendors> getHigherVendors(BusinessParams params) {
		
		Boolean filterFlagDate = params.getDateFrom() != null && params.getDateUntil() != null;
		Boolean filterFlagSortBy = params.getSortBy() != null && params.getOrder() != null;
		Boolean filterFlagIsDisregardZero = params.isDisregardZero();
		
		List<BusinessHigherVendors> listHigherVendors = new ArrayList<BusinessHigherVendors>();
		
		InvoiceService invoiceService = new InvoiceService();
		List<Invoice> invoiceList = invoiceService.getAll();
		
		//Percorrendo invoices para montar a lista de fornecedores rentáveis
		for (Invoice invoice : invoiceList) {
			
			
			//Obtendo a data para diferenciar casamentos com e sem data
			Date invoiceDate = DateHelper.parseDate(invoice.getCREATED_AT());
			
			//Guardando ID do fornecedor, para incrementar os valores e reatribuir na mesma posição da lista
			int indexVendorInHigherVendorList = getIndexVendorInHigherVendorList(invoice.getVENDOR_ID(), listHigherVendors);
			
			//Verificando se a data est� vazia. Se sim, atruibuo a contagem para casamentos sem data
			if(invoiceDate == null && !filterFlagDate) {
				
				InsertNewOrIncrementVendor(indexVendorInHigherVendorList, listHigherVendors, invoice);
				
			} else if(invoiceDate != null) {
				
				if(filterFlagDate) {
					
					if(invoiceDate.after(params.getDateFrom()) && invoiceDate.before(params.getDateUntil())) {
						
						InsertNewOrIncrementVendor(indexVendorInHigherVendorList, listHigherVendors, invoice);
						
					}
						
				} else {
					
					InsertNewOrIncrementVendor(indexVendorInHigherVendorList, listHigherVendors, invoice);
					
				}
				
			}
			
		}
		
		BusinessHigherVendorsSorter BHVSorter = new BusinessHigherVendorsSorter(listHigherVendors);
		
		if(filterFlagSortBy) {
			
			if(params.isDisregardZero()) {
				listHigherVendors = removeIndexWithValueMinorsZero(listHigherVendors, params);
				BHVSorter = new BusinessHigherVendorsSorter(listHigherVendors);
			}
			
			if( params.getSortBy().equals("profit_margin") && params.getOrder().equals("asc")) {
				
				return BHVSorter.getSortedHigherVendorsByProfitMarginAsc();
				
			} else if( params.getSortBy().equals("profit_margin") && params.getOrder().equals("desc")) {
				
				return BHVSorter.getSortedHigherVendorsByProfitMarginDesc();
				
			} else if( params.getSortBy().equals("total_profit") && params.getOrder().equals("asc")) {
				
				return BHVSorter.getSortedHigherVendorsByTotalProfitAsc();
				
			} else if( params.getSortBy().equals("total_profit") && params.getOrder().equals("desc")) {
				
				return BHVSorter.getSortedHigherVendorsByTotalProfitDesc();
				
			} else if( params.getSortBy().equals("accepted_invoices") && params.getOrder().equals("asc")) {
				
				return BHVSorter.getSortedHigherVendorsByAceptedInvoicesAsc();
				
			} else if( params.getSortBy().equals("accepted_invoices") && params.getOrder().equals("desc")) {
				
				return BHVSorter.getSortedHigherVendorsByAcceptedInvoicesDesc();
				
			} else if( params.getSortBy().equals("declined_invoices") && params.getOrder().equals("asc")) {
				
				return BHVSorter.getSortedHigherVendorsByDeclinedInvoicesAsc();
				
			} else if( params.getSortBy().equals("declined_invoices") && params.getOrder().equals("desc")) {
				
				return BHVSorter.getSortedHigherVendorsByDeclinedInvoicesDesc();
				
			}
			
		}
		
		return BHVSorter.getSortedHigherVendorsByProfitMarginDesc();
		
	}
	
	private List<BusinessHigherVendors> removeIndexWithValueMinorsZero(List<BusinessHigherVendors> list, BusinessParams params) {
		
		List<BusinessHigherVendors> returnList = new ArrayList<BusinessHigherVendors>();
		
		for (BusinessHigherVendors item : list) {
			
			if( params.getSortBy().equals("profit_margin") && item.getProfitMargin() > 0 ) {
				
				returnList.add(item);
				
			} else if( params.getSortBy().equals("total_profit") && item.getTotalProfit() > 0 ) {
				
				returnList.add(item);
				
			} else if( params.getSortBy().equals("accepted_invoices") && item.getAcceptedInvoices() > 0 ) {
				
				returnList.add(item);
				
			} else if( params.getSortBy().equals("declined_invoices") && item.getDeclinedInvoices() > 0 ) {
				
				returnList.add(item);
				
			}
			
		}
		
		return returnList;
		
	}
	
	private void InsertNewOrIncrementVendor(int index, List<BusinessHigherVendors> listHigherVendors, Invoice invoice) {
		
		//Se o fornecedor já existir na lista
		if( index != -1 ) {
			
			// Incrementando valores a um fornecedor já existente
			listHigherVendors.set(index, IncrementValuesInVendor(listHigherVendors.get(index), invoice));
			
		}else {
			
			// Utilizando fornecedor temporário para atribuir as informações e adicionar à lista
			listHigherVendors.add(setInfosNewVendor(invoice));
			
		}
		
	}
	
	private BusinessHigherVendors setInfosNewVendor(Invoice invoice) {
		
		BusinessHigherVendors busines = new BusinessHigherVendors();
		
		busines.setVendorId(invoice.getVENDOR_ID());
		busines.setTotalAmount(invoice.getAMOUNT());
		busines.setTotalVendorAmount(invoice.getVENDOR_AMOUNT());
		
		busines.setTotalProfit( MathHelper.round( invoice.getAMOUNT() - invoice.getVENDOR_AMOUNT() ) );
		busines.setProfitMargin( MathHelper.round( (busines.getTotalProfit() / busines.getTotalAmount()) * 100 ) );
		
		if(invoice.getACCEPTED()) {
			busines.setAcceptedInvoices(1);
			busines.setDeclinedInvoices(0);
		} else {
			busines.setAcceptedInvoices(0);
			busines.setDeclinedInvoices(1);
		}
		
		
		return busines;
		
	}
	
	private BusinessHigherVendors IncrementValuesInVendor(BusinessHigherVendors lastValue, Invoice invoice) {
		
		lastValue.setTotalAmount(lastValue.getTotalAmount() + invoice.getAMOUNT());
		lastValue.setTotalVendorAmount( MathHelper.round( lastValue.getTotalVendorAmount() + invoice.getVENDOR_AMOUNT() ) );
		lastValue.setTotalProfit( MathHelper.round( lastValue.getTotalAmount() - lastValue.getTotalVendorAmount() ) );
		lastValue.setProfitMargin( MathHelper.round( (lastValue.getTotalProfit() / lastValue.getTotalAmount()) * 100) );
		
		if(invoice.getACCEPTED()) {
			lastValue.setAcceptedInvoices(lastValue.getAcceptedInvoices() + 1);
		} else {
			lastValue.setDeclinedInvoices(lastValue.getDeclinedInvoices() + 1);
		}
		
		return lastValue;
		
	}
	 
	private int getIndexVendorInHigherVendorList(int vendorId, List<BusinessHigherVendors> higherVendorList) {
        for (int i = 0; i < higherVendorList.size(); i++) {
            if (higherVendorList.get(i) !=null && higherVendorList.get(i).getVendorId() == vendorId) {
                return i;
            }
        }
        return -1;// not there is list
    }
	
	// Comparators
	
	public static Comparator<BusinessHigherVendors> profitMarginComparatorDesc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getProfitMargin() < bhv1.getProfitMargin() ? -1 : 
				(bhv2.getProfitMargin() == bhv1.getProfitMargin() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> profitMarginComparatorAsc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getProfitMargin() > bhv1.getProfitMargin() ? -1 : 
				(bhv2.getProfitMargin() == bhv1.getProfitMargin() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> totalProfitComparatorDesc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getTotalProfit() < bhv1.getTotalProfit() ? -1 : 
				(bhv2.getTotalProfit() == bhv1.getTotalProfit() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> totalProfitComparatorAsc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getTotalProfit() > bhv1.getTotalProfit() ? -1 : 
				(bhv2.getTotalProfit() == bhv1.getTotalProfit() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> acceptedInvoicesComparatorDesc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getAcceptedInvoices() < bhv1.getAcceptedInvoices() ? -1 : 
				(bhv2.getAcceptedInvoices() == bhv1.getAcceptedInvoices() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> acceptedInvoicesComparatorAsc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getAcceptedInvoices() > bhv1.getAcceptedInvoices() ? -1 : 
				(bhv2.getAcceptedInvoices() == bhv1.getAcceptedInvoices() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> declinedInvoicesComparatorDesc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getDeclinedInvoices() < bhv1.getDeclinedInvoices() ? -1 : 
				(bhv2.getDeclinedInvoices() == bhv1.getDeclinedInvoices() ? 0 : 1));
		}
	};
	
	public static Comparator<BusinessHigherVendors> declinedInvoicesComparatorAsc = new Comparator<BusinessHigherVendors>() {
		@Override
		public int compare(BusinessHigherVendors bhv1, BusinessHigherVendors bhv2) {
			return (bhv2.getDeclinedInvoices() > bhv1.getDeclinedInvoices() ? -1 : 
				(bhv2.getDeclinedInvoices() == bhv1.getDeclinedInvoices() ? 0 : 1));
		}
	};
	
	
	@Override
	public String toString() {
		return "[vendorId = "+ vendorId 
				+"[totalAmount = "+ totalAmount 
				+"[totalVendorAmount = "+ totalVendorAmount 
				+"[totalProfit = "+ totalProfit 
				+"[profitMargin = "+ profitMargin 
				+"[accepteInvoices = "+ acceptedInvoices 
				+", declinedInvoices = "+ declinedInvoices +"]";
		
	}
}
