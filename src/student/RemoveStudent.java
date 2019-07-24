package student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user.*;

public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userdao=new UserDAOImpl();
		String id=(String) request.getParameter("id");
		try {
			userdao.removeStudent(id);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		response.sendRedirect("AdminHomePage");

	}

}
