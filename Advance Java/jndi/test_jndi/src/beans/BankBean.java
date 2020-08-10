package beans;

import business_objs.BankUser;
import dao_cp.BankDao;

public class BankBean {
	private String name, pass;
	private BankDao dao;
	private BankUser validUser;

	public BankBean() {
		System.out.println("in bean constr ");
		dao = new BankDao();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("in set name");
		this.name = name;
	}

	public BankUser getValidUser() {
		return validUser;
	}

	public void setPass(String pass) {
		System.out.println("in set pass");
		this.pass = pass;
	}

	// B.L for validating user 
	
	public String validateUser() throws Exception {
		validUser = dao.validateUser(name, pass);
		if (validUser == null)
			return "invalid";
		return "valid";
	}
	public String registerUser() throws Exception {
		return dao.registerUser(name, pass);
		
	}


}
