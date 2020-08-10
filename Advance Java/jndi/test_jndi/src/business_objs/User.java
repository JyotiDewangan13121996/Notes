package business_objs;

public class User {
	private String email,password,prefs;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password, String prefs) {
		super();
		this.email = email;
		this.password = password;
		this.prefs = prefs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrefs() {
		return prefs;
	}
	public void setPrefs(String prefs) {
		this.prefs = prefs;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", prefs=" + prefs + "]";
	}
	

}
