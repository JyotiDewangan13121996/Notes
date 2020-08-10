package pojos;
import javax.persistence.*;

@Entity
@Table(name="stud_adr")
public class Address extends AbstractEntity{
	
	private String city,state,country,cellNo;
	//bi dir one to one mapping
	private Student stud;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String city, String state, String country, String cellNo) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.cellNo = cellNo;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(length=20)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(length=10,unique=true)
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	@OneToOne
	@JoinColumn(name="s_id")
	public Student getStud() {
		return stud;
	}
	public void setStud(Student stud) {
		this.stud = stud;
	}
	@Override
	public String toString() {
		return "Address [adrId=" +getId() + ", city=" + city + ", state=" + state + ", country=" + country + ", cellNo="
				+ cellNo + "]";
	}
	

}
