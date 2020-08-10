package business_objs;

public class BankUser {
	private int id;
	private String name,pass;
	public BankUser() {
		// TODO Auto-generated constructor stub
	}
	public BankUser(int id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "BankUser [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	

}
