package bean.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DBConnection.*;
public class BookDAOImpl implements BookDAO{
	
	public void addBook(String id,String name,String author,int totalCount,float cost) {
		String sql="insert into book values(?,?,?,?,?,?)";
		try(Connection con=DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, author);
			st.setInt(4, totalCount);
			st.setInt(5, totalCount);
			st.setFloat(6, cost);
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public ArrayList<Book> getAllAvailableBook(String name) throws Exception{
		ArrayList<Book> books=new ArrayList<Book>();
		String sql="select bookId,bookName,author,availableCount from book where 1=? and availableCount>0;";
		ResultSet rs=null;
		try(Connection con=DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, name);
			rs=st.executeQuery();
			while(rs.next())
			{
				books.add(getBookObject(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
		}
		return books;
	}
	public ArrayList<Book> getAllByAuthorName(String name) throws Exception{
		ArrayList<Book> books=new ArrayList<Book>();
		String sql="select bookId,bookName,author,availableCount from book where author=? and availableCount>0";
		ResultSet rs=null;
		try(Connection con=DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, name);
			rs=st.executeQuery();
			while(rs.next()) {
				books.add(getBookObject(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
		}
		return books;
	}
	public ArrayList<Book> getAllByBookName(String name) throws Exception{
		ArrayList<Book> books=new ArrayList<Book>();
		String sql="select bookId,bookName,author,availableCount from book where bookName=? and availableCount>0";
		ResultSet rs=null;
		try(Connection con=DataBaseConnection.initializeDB();PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, name);
			rs=st.executeQuery();
			while(rs.next())
				books.add(getBookObject(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs.close();
		}
		return books;
	}
	public ArrayList<Book> getAllBook() throws Exception{
		ArrayList<Book> books=new ArrayList<Book>();
		String sql="select * from book";
		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
			while(rs.next())
				books.add(getBookObject(rs));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return books;
	}
	
	public Book getBookObject(ResultSet rs) throws SQLException {
		Book book=new Book();
		int i=1;
		if(hasColumn(rs,"bookId"))
			book.setBookId(rs.getString(i++));
		if(hasColumn(rs,"bookName"))
			book.setBookName(rs.getString(i++));
		if(hasColumn(rs,"author"))
			book.setAuthor(rs.getString(i++));
		if(hasColumn(rs,"availableCount"))
			book.setAvailableCount(rs.getInt(i++));
		if(hasColumn(rs,"totalCount"))
			book.setTotalCount(rs.getInt(i++));
		if(hasColumn(rs,"cost"))
			book.setCost(rs.getFloat(i++));
		return book;
		
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
