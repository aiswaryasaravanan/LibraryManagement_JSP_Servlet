

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class IsAdmin implements Filter {

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();

		String id=(String) request.getParameter("id");
		try {
			Connection con=DBConnection.DataBaseConnection.initializeDB();
			PreparedStatement st=con.prepareStatement("select isAdmin from user where id=?");
			st.setString(1, id);
			
			ResultSet rs=st.executeQuery();
			rs.next();

			if(rs.getInt(1)>0) {
				chain.doFilter(request, response);
			}else {
				out.println("cannot remove Admin!!");
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("AdminHomePage");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			out.println(e);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
