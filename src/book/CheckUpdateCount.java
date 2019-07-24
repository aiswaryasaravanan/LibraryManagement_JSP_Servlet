package book;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.sql.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/UpdateOnRenew")
public class CheckUpdateCount implements Filter {

	String sql;
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out=response.getWriter();
		String[] transactionIds = request.getParameterValues("transactionIds");
		int flag=0;
		
		HttpSession session=((HttpServletRequest) request).getSession(false);
		
		try {
			Connection con=DBConnection.DataBaseConnection.initializeDB();
			Statement st=con.createStatement();
			String id=(String)session.getAttribute("id");
						
			for(String transactionId : transactionIds) {
				sql="select renewCount from transaction where transactionId="+transactionId+";";
				ResultSet rs=st.executeQuery(sql);
				rs.next();
				if(rs.getInt(1)>=2) {
					flag=1;
					RequestDispatcher rd=request.getRequestDispatcher("StudentHomePage");
					rd.forward(request, response);
				}
			}	
			if(flag==0) {
				chain.doFilter(request, response);
			}

		}catch(Exception e) {
			out.println(e);
			e.printStackTrace();
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
