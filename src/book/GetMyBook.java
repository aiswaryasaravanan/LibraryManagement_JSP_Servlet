package book;

import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.transaction.Transaction;
import bean.transaction.TransactionDAO;
import bean.transaction.TransactionDAOImpl;

public class GetMyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sql;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		HttpSession session=request.getSession(false);
		TransactionDAO transactiondao=new TransactionDAOImpl();
		
		try {
			if(request.getAttribute("status").equals("current")) {
				transactions=transactiondao.getMyBook((String) session.getAttribute("id"));
			}else if(request.getAttribute("status").equals("past")) {
				transactions=transactiondao.getMyPastBook((String) session.getAttribute("id"));
			}else if(request.getAttribute("status").equals("renew")) {
				transactions=transactiondao.getBookToRenew((String) session.getAttribute("id"));
			}
		}catch(Exception e) {
			
		}
		request.setAttribute("transactions", transactions);
	}

}
