package bean.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAOImpl implements LoginDAO{
	public boolean isValidUser(String id,String password) throws Exception {
		String sql="select id from login where id=? and password=?";
		ResultSet rs=null;
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			st.setString(2, password);
			rs=st.executeQuery();
			if(rs.next()) {
					return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			rs.close();
		}
		return false;
	}
}
