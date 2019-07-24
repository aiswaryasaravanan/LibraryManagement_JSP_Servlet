package bean.user;

public class User{
	private String id;
	private String name;
	private long phoneNo;
	private String email;
	private String address;
	private int isAdmin;
	private float fineAmount;
	
	public User(){}
	
	public void setId(String id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo=phoneNo;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin=isAdmin;
	}
	public void setFineAmount(float fineAmount) {
		this.fineAmount=fineAmount;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public float getFineAmount() {
		return fineAmount;
	}

}
