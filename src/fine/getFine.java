package fine;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.transaction.*;
import bean.user.*;


public class getFine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float fine;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		TransactionDAO transactiondao=new TransactionDAOImpl();
		try {
			fine=transactiondao.getFine((String) session.getAttribute("id"));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		request.setAttribute("fine", fine);
	}

}
