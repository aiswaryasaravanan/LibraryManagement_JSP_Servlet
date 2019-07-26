package user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.adventnet.persistence.DataAccessException;

import bean.user.*;

public class GetName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		UserDAO userdao=new UserDAOImpl();
		try {
			name=userdao.getName((String)session.getAttribute("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("name", name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
