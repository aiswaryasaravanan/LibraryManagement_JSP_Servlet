package book;

import java.io.IOException;
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
		String[] bookIds=request.getParameterValues("bookIds");
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

//		try {
//			Connection con=DBConnection.DataBaseConnection.initializeDB();
//			
//			for(String bookId:bookIds) {
//				sql="update book set availableCount=(select availableCount where bookId='"+bookId+"')-1 where bookId='"+bookId+"'";
//				Statement st=con.createStatement();
//				st.executeUpdate(sql);
//								
//				Calendar cal = Calendar.getInstance();
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//				
//				java.sql.Date issueDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
//				cal.add(Calendar.DAY_OF_MONTH, 15);
//				java.sql.Date dueDate=java.sql.Date.valueOf(sdf.format(cal.getTime()));
//	
//				sql="insert into transaction (studentId,bookId,issueDate,dueDate) values('"+session.getAttribute("id")+"','"+bookId + "'," + "DATE '"+issueDate +"'," + "DATE '"+ dueDate + "');";
//				Statement st1=con.createStatement();
//				st1.executeUpdate(sql);
//			}
//			
//			response.sendRedirect("StudentHomePage");
//
//		}catch(Exception e) {
//			out.println(e);
//			e.printStackTrace();
//		}
	}

	


}
