package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
	private Integer id;
	private String name;
	private LocalDate strt, end;
	private double fees;
	private int capacity;
	// Course HAS-A Student(many)
	private List<Student> students = new ArrayList<>();

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String name, LocalDate strt, LocalDate end, double fees, int capacity) {
		super();
		this.name = name;
		this.strt = strt;
		this.end = end;
		this.fees = fees;
		this.capacity = capacity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// col type=date
	public LocalDate getStrt() {
		return strt;
	}

	public void setStrt(LocalDate strt) {
		this.strt = strt;
	}

	// col type=date
	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@OneToMany(mappedBy = "selectedCourse",cascade=CascadeType.ALL)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// convenience methods(helper methods) to establish bi-dir asso
	public void addStudent(Student s) {
		students.add(s);// course--->student
		s.setSelectedCourse(this);//student-->course

	}

	public void removeStudent(Student s) {
		students.remove(s);
		s.setSelectedCourse(null);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", strt=" + strt + ", end=" + end + ", fees=" + fees
				+ ", capacity=" + capacity + "]";
	}

}
