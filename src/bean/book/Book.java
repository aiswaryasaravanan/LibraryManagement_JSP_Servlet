package bean.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book{
	private int transactionId;
	private String bookId;
	private String bookName;
	private String author;
	private int totalCount;
	private int availableCount;
	private Date issueDate;
	private Date dueDate;
	private float cost;
	
	public Book() {}

	public void setBookId(String bookId) {
		this.bookId=bookId;
	}
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount=availableCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
	}
	public void setCost(float cost) {
		this.cost=cost;
	}
	
	
	public int getTransactionId() {
		return transactionId;
	}
	public String getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public float getCost() {
		return cost;
	}
	

	@Override
	public String toString() {
		return "Book [transactionId=" + transactionId + ", bookId=" + bookId + ", bookName=" + bookName + ", author="
				+ author + ", totalCount=" + totalCount + ", availableCount=" + availableCount + ", issueDate="
				+ issueDate + ", dueDate=" + dueDate + ", cost=" + cost + "]";
	}
	
}
