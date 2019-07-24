package user;

import java.io.IOException;
import java.util.ArrayList;

import bean.user.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> users=new ArrayList<User>();
		UserDAO userdao=new UserDAOImpl();
		
		users=userdao.getAllUser();
		
		request.setAttribute("users", users);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllUser");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
