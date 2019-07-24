package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.book.*;

public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookdao=new BookDAOImpl();
		try {
			bookdao.addBook(request.getParameter("id"),request.getParameter("name"),request.getParameter("author"),Integer.parseInt(request.getParameter("totalCount")),Float.parseFloat(request.getParameter("cost")));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		response.sendRedirect("AdminHomePage");		
	}


}
