package student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user.*;

public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		UserDAO userdao=new UserDAOImpl();
		
		String id=(String) request.getParameter("id");
		String name=(String) request.getParameter("name");
		String phoneno=request.getParameter("phoneno");
		String email=(String) request.getParameter("email");
		String address=(String) request.getParameter("address");
		long phoneNo=Long.parseLong(phoneno);
		try {
			userdao.addStudent(id,name,phoneNo,email,address);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		response.sendRedirect("AdminHomePage");

	}
}
