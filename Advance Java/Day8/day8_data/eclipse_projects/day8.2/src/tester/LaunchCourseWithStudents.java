package tester;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

public class LaunchCourseWithStudents {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter course details nm strt(yr-mon-day) end fee capa");
//def dateformat yyyy-MM-dd --0 prefix 
			Course c1 = new Course(sc.next(), LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble(),
					sc.nextInt());
			for(int i=0;i<3;i++)
			{
				System.out.println("Enter student details nm email");
				Student s=new Student(sc.next(), sc.next());
				c1.addStudent(s);
			}
			//dao 
			CourseDaoImpl dao=new CourseDaoImpl();
			System.out.println(dao.launchCourse(c1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
