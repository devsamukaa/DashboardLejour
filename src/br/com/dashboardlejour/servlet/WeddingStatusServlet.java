package br.com.dashboardlejour.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.dashboardlejour.business.BusinessHigherBudgetWeddings;
import br.com.dashboardlejour.business.BusinessParams;
import br.com.dashboardlejour.business.BusinessWeddingStatus;

/**
 * Servlet implementation class WeddingStatusServlet
 */
@WebServlet("/WeddingStatusServlet")
public class WeddingStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeddingStatusServlet() {
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
        //response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
 
        BusinessParams businessParams = new BusinessParams(request);
        
        BusinessWeddingStatus business = new BusinessWeddingStatus();
        List<BusinessWeddingStatus> businessList = null;
        
        if((businessParams.getDateFrom()!= null && businessParams.getDateUntil()!= null)||businessParams.getWeddingType()!=null) {
        	businessList = business.getWeddingStatus(businessParams);
        }else {
        	businessList = business.getWeddingStatus();
        }
		
		String jsonString = new Gson().toJson(businessList);
		
		response.getWriter().append(jsonString);
 
        out.close();
	}
}
