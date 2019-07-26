package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.transaction.*;

public class UpdateOnRenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sql;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] transactionIds=request.getParameterValues("transactionIds");
		PrintWriter out=response.getWriter();
		
		if(transactionIds==null) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.print("alert(\"No Books selected\");");
			out.println("location='StudentHomePage.jsp';");
			out.println("</script>");
		}else {
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			TransactionDAO transactiondao=new TransactionDAOImpl();
					
			try {
				for(String transactionId : transactionIds) {
					java.sql.Date currentDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
					cal.add(Calendar.DAY_OF_MONTH, 10);
					java.sql.Date dueDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
					System.out.println(currentDate);
					System.out.println(dueDate);
					transactiondao.updateOnRenew(Integer.parseInt(transactionId),dueDate);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}response.sendRedirect("StudentHomePage");	
		}
	}
}
