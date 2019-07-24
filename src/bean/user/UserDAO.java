package bean.user;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
	public ArrayList<User> getAllUser();
	public float getFine(String id) throws Exception;
	public void setFine(String id,float amount);
	public void addStudent(String id,String name,long phoneno,String email,String address);
	public void removeStudent(String id);
	public boolean isAdmin(String id) throws SQLException;
	public String getName(String id) throws SQLException;
}
