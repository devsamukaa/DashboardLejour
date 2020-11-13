package sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.dashboardlejour.business.BusinessHigherVendors;

public class BusinessHigherVendorsSorter {
	
	List<BusinessHigherVendors> businessHigherVendorsList = new ArrayList<>();
	
	public BusinessHigherVendorsSorter(List<BusinessHigherVendors> listHigherVendors) {
		this.businessHigherVendorsList = listHigherVendors;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByProfitMarginDesc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.profitMarginComparatorDesc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByProfitMarginAsc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.profitMarginComparatorAsc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByTotalProfitDesc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.totalProfitComparatorDesc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByTotalProfitAsc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.totalProfitComparatorAsc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByAcceptedInvoicesDesc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.acceptedInvoicesComparatorDesc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByAceptedInvoicesAsc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.acceptedInvoicesComparatorAsc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByDeclinedInvoicesDesc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.declinedInvoicesComparatorDesc);
		return businessHigherVendorsList;
	}
	
	public List<BusinessHigherVendors> getSortedHigherVendorsByDeclinedInvoicesAsc() {
		Collections.sort(businessHigherVendorsList, BusinessHigherVendors.declinedInvoicesComparatorAsc);
		return businessHigherVendorsList;
	}
}
