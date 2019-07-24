package book;

import bean.book.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> books=new ArrayList<Book>();
		BookDAO bookdao=new BookDAOImpl();
		PrintWriter out=response.getWriter();
		
		try {
			books=bookdao.getAllBook();
			request.setAttribute("books", books);
			
		}catch (Exception e) {
			out.println(e);
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllBook");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
