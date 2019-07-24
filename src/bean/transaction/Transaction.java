package bean.transaction;

import java.sql.Date;

import bean.book.Book;
import bean.user.User;

public class Transaction{
	private int transactionId;
	private User user;
	private Book book;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private int renewCount;
	
	public Transaction(){}
	
	public void setTransactionId(int transactionId) {
		this.transactionId=transactionId;
	}
	public void setUser(User user) {
		this.user=user;
	}
	public void setBook(Book book) {
		this.book=book;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate=issueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate=dueDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate=returnDate;
	}
	public void setRenewCount(int renewCount) {
		this.renewCount=renewCount;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	public User getUser() {
		return user;
	}
	public Book getBook() {
		return book;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public int getRenewCount() {
		return renewCount;
	}


}
