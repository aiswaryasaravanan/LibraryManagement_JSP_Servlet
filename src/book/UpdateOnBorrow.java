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

public class UpdateOnBorrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String sql;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String[] bookIds=request.getParameterValues("bookIds");
		if(bookIds == null) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"No Books selected\");");
			out.println("location='SearchPage.jsp';");
			out.println("</script>");
		}else {
			HttpSession session=request.getSession(false);
			TransactionDAO transactiondao=new TransactionDAOImpl();
			session.getAttribute("id");
			
			try {
				for(String bookId:bookIds) {
					
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					
					java.sql.Date issueDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
					cal.add(Calendar.DAY_OF_MONTH, 15);
					java.sql.Date dueDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
					
					int transactionId=transactiondao.updateOnBorrow((String)session.getAttribute("id"),bookId,issueDate,dueDate);
					transactiondao.updateAvailableCount(-1,transactionId);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}response.sendRedirect("StudentHomePage");
		}
	}
}
