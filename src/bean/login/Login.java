package bean.login;

import bean.user.User;

public class Login {
	private User user;
	private String password;
	
	public Login() {}
	
	public User getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUser(User user) {
		this.user=user;
	}
	public void setPassword(String password) {
		this.password=password;
	}
}
