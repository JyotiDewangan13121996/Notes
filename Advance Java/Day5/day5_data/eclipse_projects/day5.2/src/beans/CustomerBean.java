package beans;

import dao.UserDaoImpl;
import pojos.User;

public class CustomerBean {
	// properties
	//clnt' state
	private String email, password;
	//internal property
	private UserDaoImpl dao;
	//results of B.L
	private User details;
	private String message;

	// constr
	public CustomerBean() throws Exception {
		System.out.println("in cust bean ctor");
		// create dao inst
		dao = new UserDaoImpl();
	}

	// setter n getters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getDetails() {
		return details;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getMessage() {
		return message;
	}

	// B.L method
	public String validateCustomer() throws Exception {
		System.out.println("B.L validate " + email + " " + password);
		// invoke dao's method
		details = dao.authenticateUser(email, password);
		if(details == null) {
			message="Invalid Login , Pls retry....";
			return "login";//nav outcome
		}
		//valid login
		message="Login Successful";
		return "category";
	}

}
