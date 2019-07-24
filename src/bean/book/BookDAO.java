package bean.book;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.transaction.Transaction;

public interface BookDAO {

	public ArrayList<Book> getAllByAuthorName(String name) throws Exception;
	public ArrayList<Book> getAllByBookName(String name) throws Exception;
	public ArrayList<Book> getAllAvailableBook(String name) throws Exception;
	public ArrayList<Book> getAllBook() throws Exception;
	public void addBook(String id,String name,String author,int totalCount,float cost);

}
