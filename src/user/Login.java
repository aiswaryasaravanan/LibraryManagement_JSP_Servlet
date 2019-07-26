package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBConnection.DataBaseConnection;
import bean.login.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		LoginDAO logindao=new LoginDAOImpl();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		try {
			if(logindao.isValidUser(id,password)) {
				session.setAttribute("id", id);
				RequestDispatcher rd=request.getRequestDispatcher("Navigation");
				rd.forward(request, response);
			}else {
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.print("alert(\"Wrong username or password\");");
				out.println("location='index.jsp';");
				out.println("</script>");
				
//				out.println("<meta http-equiv='refresh' content='3;URL=index.jsp'>");
//				out.println("<p style='color:red;'>User or password incorrect!</p>");
				
//				response.sendRedirect("index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		doGet(request, response);
	}

}
