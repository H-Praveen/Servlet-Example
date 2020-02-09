package demo.java.servlet.service;


/**
 * @author 172730
 *
 */
public class LoginValidationService {

	/**
	 * <p> This method is to validate the login details </p>
	 * @param username: Requested customer's username and it is unique in db
	 * @param password: Requested Customer's password
	 * @return Boolean TRUE if login details are valid
	 */
	public boolean loginValidation(String username, String password) {
		
		boolean isValid = Boolean.FALSE;
		if("admin".equalsIgnoreCase(username) && "admin".equals(password)) {

			isValid = Boolean.TRUE;
		}
		return isValid;
	}
}
