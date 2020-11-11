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
import br.com.dashboardlejour.business.BusinessWeddingInTheYear;

/**
 * Servlet implementation class WeddingsHigherBudgetWeddings
 */
@WebServlet("/WeddingsHigherBudgetWeddings")
public class HigherBudgetWeddingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HigherBudgetWeddingsServlet() {
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
        
        BusinessHigherBudgetWeddings business = new BusinessHigherBudgetWeddings();
        List<BusinessHigherBudgetWeddings> businessList = null;
        
        businessList = business.getWeddingsWithBudgetOverX(businessParams);
		
		String jsonString = new Gson().toJson(businessList);
		
		response.getWriter().append(jsonString);
 
        out.close();
 
    }


}
