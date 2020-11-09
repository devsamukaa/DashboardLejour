package br.com.dashboardlejour.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.dashboardlejour.business.BusinessParams;
import br.com.dashboardlejour.business.BusinessWeddingInTheYear;
import br.com.dashboardlejour.helpers.DateHelper;

/**
 * Servlet implementation class WeddingsInTheYearServlet
 */
@WebServlet("/weddings_during_year")
public class WeddingsInTheYearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeddingsInTheYearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
 
        BusinessParams businessParams = new BusinessParams(request);
        
        BusinessWeddingInTheYear business = new BusinessWeddingInTheYear();
        List<BusinessWeddingInTheYear> businessList = null;
        
        if( businessParams.getYear() != null || businessParams.getWeddingType() != null ) {
        	businessList = business.getWeddingsInTheYear(businessParams);
        }else {
        	businessList = business.getWeddingsInTheYear();
        }
		
		String jsonString = new Gson().toJson(businessList);
		
		response.getWriter().append(jsonString);
 
        out.close();
 
    }

}
