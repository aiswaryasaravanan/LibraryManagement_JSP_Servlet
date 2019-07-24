package book;

import bean.transaction.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetIssuedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TransactionDAO transactiondao=new TransactionDAOImpl();
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		
		try {
			transactions=transactiondao.getIssuedBook();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		request.setAttribute("transactions", transactions);
		RequestDispatcher rd=request.getRequestDispatcher("ViewIssuedBook");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
