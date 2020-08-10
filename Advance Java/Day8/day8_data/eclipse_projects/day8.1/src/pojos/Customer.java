package pojos;

import java.util.Date;
import javax.persistence.*;

@Entity //mandatory cls level run time annoation
@Table(name="dac_customers")
public class Customer {
	//id property MUST be Serializable
	private Integer custId;
	private String name,email,password,confirmPassword,role;
	private double regAmount;
	private Date regDate;
	//Customer HAS-A type(enum)
	private CustomerType custType;
	private byte[] image;
	//MUST --def constr
	public Customer() {
		System.out.println("in customer ctor");
	}
	public Customer(String name, String email, String password, String confirmPassword, String role, double regAmount,
			Date regDate, CustomerType custType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.custType = custType;
	}
	//must supply ALL s/g
	@Id //mandatory -- PK constraint  --- user will supply id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto increment --suited for MySQL
	@Column(name="cust_id")
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,unique=true)//unique constraint
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20,nullable=false)//NOT NULL constraint
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Transient //skip from persistence--no col generation
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Column(length=20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	//def col type=datetime
	@Temporal(TemporalType.DATE)//col type=date
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	//def col = ordinal val
	@Enumerated(EnumType.STRING)//enum names will be added in db
	@Column(length=20,name="cust_type")
	public CustomerType getCustType() {
		return custType;
	}
	public void setCustType(CustomerType custType) {
		this.custType = custType;
	}
	@Lob //col type=longblob
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", email=" + email + ", role=" + role + ", regAmount="
				+ regAmount + ", regDate=" + regDate + ", custType=" + custType + "]";
	}
	

}
