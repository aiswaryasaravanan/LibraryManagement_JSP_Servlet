package bean.transaction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DBConnection.DataBaseConnection;
import bean.book.Book;
import bean.user.User;

public class TransactionDAOImpl implements TransactionDAO{
	public ArrayList<Transaction> getMyBook(String id) throws Exception {
		
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		String sql="select transactionId,book.bookId,bookName,author,transaction.issueDate,transaction.dueDate from book,transaction where book.bookId=transaction.bookId and returnDate is null and transaction.studentId='"+id+"' order by dueDate";

		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
			while(rs.next()) {
				transactions.add(getTransactionObject(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return transactions;
	}
	
	public ArrayList<Transaction> getMyPastBook(String id) throws Exception {
		
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		String sql="select transactionId,book.bookId,bookName,author,transaction.issueDate,transaction.dueDate from book,transaction where book.bookId=transaction.bookId and returnDate is not null and transaction.studentId='"+id+"' order by returnDate";

		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
			while(rs.next()) {
				transactions.add(getTransactionObject(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return transactions;	
	}
	
	
	public ArrayList<Transaction> getIssuedBook() throws Exception{
		ArrayList<Transaction> transactions=new ArrayList<Transaction>();
		String sql="select transaction.bookId,bookname,id,name,issueDate,duedate from transaction join book on transaction.bookid=book.bookid join user on transaction.studentId=user.id where returnDate is null";
		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql)){
			while(rs.next())
				transactions.add(getTransactionObject(rs));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return transactions;
	}
	
	public void updateOnRenew(int transactionId,Date dueDate) {
		String sql="Update transaction set dueDate= DATE '"+dueDate+"',renewCount=renewCount+1 where transactionId="+transactionId+"";
		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement()){
			st.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void updateAvailableCount(int count,int transactionId) {
		String sql="update book set availableCount=availableCount+"+count+" where bookId=(select bookId from transaction where transactionId="+transactionId+")";
		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement()){
			st.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void updateReturnDate(Date returnDate,int transactionId) {
		String sql="Update transaction set returnDate= DATE '"+returnDate+"' where transactionId="+transactionId+"";
		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement()){
			st.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	int transactionId;
	public int updateOnBorrow(String id,String bookId,Date issueDate,Date dueDate) throws Exception {
		String sql="insert into transaction (studentId,bookId,issueDate,dueDate) values('"+id+"','"+bookId + "'," + "DATE '"+issueDate +"'," + "DATE '"+ dueDate + "');";
		String sql1="select count(*) from transaction;";
		ResultSet rs=null;
		try(Connection con=DataBaseConnection.initializeDB();Statement st=con.createStatement();Statement st1=con.createStatement()){
			st.executeUpdate(sql);
			rs=st1.executeQuery(sql1);
			while(rs.next())
				transactionId=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}finally {
			rs.close();
		}
		return transactionId;
	}
	public Transaction getTransactionObject(ResultSet rs) throws Exception{
		Transaction transaction=new Transaction();
		Book book=new Book();
		User user=new User();
		
		int i=1;
		
		if(hasColumn(rs,"transactionId")) 
			transaction.setTransactionId(rs.getInt(i++));
		
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
		transaction.setBook(book);
		
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
		transaction.setUser(user);
		
		if(hasColumn(rs,"issueDate"))
			transaction.setIssueDate(rs.getDate(i++));
		if(hasColumn(rs,"dueDate"))
			transaction.setDueDate(rs.getDate(i++));
		if(hasColumn(rs,"returnDate"))
			transaction.setReturnDate(rs.getDate(i++));
		if(hasColumn(rs,"renewCount"))
			transaction.setRenewCount(rs.getInt(i++));
		
		return transaction;
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
