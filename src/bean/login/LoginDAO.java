package bean.login;

public interface LoginDAO {
	boolean isValidUser(String id,String password) throws Exception;
}
