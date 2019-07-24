package bean.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{
	
	public void addStudent(String id, String name, long phoneno, String email, String address) {
		String sql="insert into user(id,name,phoneno,email,address,isAdmin,fineAmount) values(?,?,?,?,?,?,?)";
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			st.setString(2, name);
			st.setLong(3, phoneno);
			st.setString(4, email);
			st.setString(5, address);
			st.setInt(6, 0);
			st.setFloat(7,0.0f);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void removeStudent(String id) {
		String sql="delete from user where id=?";
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public ArrayList<User> getAllUser(){
		ArrayList<User> users=new ArrayList<User>();
		String sql="select * from user where isAdmin=0";
		
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
			while(rs.next())
				users.add(getUserObject(rs));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return users;
	}
	float fine;
	public float getFine(String id) throws Exception {
		String sql="select fineAmount from user where id=?";		//statement is enough
		ResultSet rs=null;
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			rs=st.executeQuery();
			while(rs.next())
					fine=rs.getFloat(1);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			rs.close();
		}

		return fine;
	}
	
	public void setFine(String id,float amount) {
		String sql="update user set fineAmount=(select fineAmount-? where id='"+id+"') where id='"+id+"'";
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setFloat(1, amount);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public boolean isAdmin(String id) throws SQLException {
		String sql="select isAdmin from User where id=?";
		ResultSet rs=null;
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			rs=st.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)==1)
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
	
	String name;
	public String getName(String id) throws SQLException {
		String sql="select name from user where id=?";
		ResultSet rs=null;
		try(Connection con=DBConnection.DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			rs=st.executeQuery();
			if(rs.next()) {
				name=rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			rs.close();
		}
		return name;
	}
	public User getUserObject(ResultSet rs) throws SQLException {
		User user=new User();
		int i=1;
		if(hasColumn(rs,"id"))
			user.setId(rs.getString(i++));
		if(hasColumn(rs,"name"))
			user.setName(rs.getString(i++));
		if(hasColumn(rs,"phoneNo"))
			user.setPhoneNo(rs.getLong(i++));
		if(hasColumn(rs,"email"))
			user.setEmail(rs.getString(i++));
		if(hasColumn(rs,"address"))
			user.setAddress(rs.getString(i++));
		if(hasColumn(rs,"isAdmin"))
			user.setIsAdmin(rs.getInt(i++));
		if(hasColumn(rs,"fineAmount"))
			user.setFineAmount(rs.getInt(i++));
		return user;
		
	}
	public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int columns = rsmd.getColumnCount();
	    for (int x = 1; x <= columns; x++) {
	        if (columnName.equals(rsmd.getColumnName(x))) {
	            return true;
	        }
	    }
	    return false;
	}
}
