package bean.transaction;

import java.sql.Date;
import java.util.ArrayList;

public interface TransactionDAO {
	public ArrayList<Transaction> getMyBook(String id) throws Exception;
	public ArrayList<Transaction> getMyPastBook(String id) throws Exception;
	public ArrayList<Transaction> getIssuedBook() throws Exception;
	public ArrayList<Transaction> getBookToRenew(String id);
	public void updateOnRenew(int transactionId,Date dueDate);
	public void updateAvailableCount(int count,int transactionId);
	public void updateReturnDate(Date returnDate,int transactionId);
	public int updateOnBorrow(String id,String bookId,Date issueDate,Date dueDate) throws Exception;
	public float getFine(String id) throws Exception;
}
