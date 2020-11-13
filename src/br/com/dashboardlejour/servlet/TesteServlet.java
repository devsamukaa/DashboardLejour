package br.com.dashboardlejour.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.dashboardlejour.bean.Invoice;
import br.com.dashboardlejour.business.BusinessParams;
import br.com.dashboardlejour.business.BusinessWeddingInTheYear;
import br.com.dashboardlejour.helpers.DateHelper;
import br.com.dashboardlejour.service.InvoiceService;

/**
 * Servlet implementation class TesteServlet
 */
@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//BusinessParams businessParams = new BusinessParams(null, null, "2019", "moderno", null);
		//BusinessWeddingInTheYear business = new BusinessWeddingInTheYear();
		
		//List<BusinessWeddingInTheYear> businessList = business.getWeddingsInTheYear(businessParams);
		
		/*for (BusinessWeddingInTheYear item : businessList) {
			response.getWriter().append(item.toString()+"<br>");
		}*/
		
		//String jsonString = new Gson().toJson(businessList);
		//response.getWriter().append(jsonString);
		
		/*String teste = "2020-11-09 00:00:00";
		
		if(teste.indexOf("NULL") != -1) {
			response.getWriter().append("ACHOU");
		}else {
			response.getWriter().append("N�O ACHOU");
		}*/
		
		InvoiceService invoiceService = new InvoiceService();
		List<Invoice> invoiceList = invoiceService.getAll();
		
		for (Invoice invoice : invoiceList) {
			response.getWriter().append(invoice.toString()+"<br/>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
