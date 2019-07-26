package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.book.*;

public class GetBook extends HttpServlet {
	String sql;

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		ArrayList<Book> books=new ArrayList<Book>();
		BookDAO bookdao=new BookDAOImpl();
		
		String typeOfSearch=(String) request.getAttribute("typeOfSearch");
		String bookName=(String) request.getAttribute("bookName");
		String authorName=(String) request.getAttribute("authorName");

		try {
			if(typeOfSearch.equals("byBook")) {
				if(bookName=="") {
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.print("alert(\"No book name is specified\");");
					out.println("location='SearchPage.jsp';");
					out.println("</script>");
				}
				books=bookdao.getAllByBookName(bookName);
			}else if(typeOfSearch.equals("byAuthor")) {
				if(authorName=="") {
					response.setContentType("text/html");
					out.println("<script type=\"text/javascript\">");
					out.print("alert(\"No Author name is specified\");");
					out.println("location='SearchPage.jsp';");
					out.println("</script>");
				}
				books=bookdao.getAllByAuthorName(authorName);
			}else if(typeOfSearch.equals("allAvailable")) {
				books=bookdao.getAllAvailableBook("1");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("books", books);


	}

}
