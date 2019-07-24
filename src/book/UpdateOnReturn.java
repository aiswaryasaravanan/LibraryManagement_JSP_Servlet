package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.transaction.*;

//@WebServlet("/UpdateOnReturn")
public class UpdateOnReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sql;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String[] transactionIds=request.getParameterValues("transactionIds");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		TransactionDAO transactiondao=new TransactionDAOImpl();
		java.sql.Date returnDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
		HttpSession session=request.getSession(false);
		
		try {
			for(String transactionId : transactionIds) {
				transactiondao.updateAvailableCount(1,Integer.parseInt(transactionId));
				transactiondao.updateReturnDate(returnDate,Integer.parseInt(transactionId));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}response.sendRedirect("StudentHomePage");
	}

}
