package pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
	private Integer id;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//def generation strategy=AUTO--native to DB(eg : Oracle -- sequence 
	// MySql --table -- hibernate_sequence
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
