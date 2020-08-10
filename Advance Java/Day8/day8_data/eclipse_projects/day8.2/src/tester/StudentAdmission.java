package tester;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Student;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

public class StudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter course name");
			String cName=sc.next();
			System.out.println("Enter student dtls nm email");
			Student s=new Student(sc.next(), sc.next());
			System.out.println("Enter address details city st co cell");
			Address a=new Address(sc.next(),sc.next(),sc.next(),sc.next());
			//establish bi dir asso between student n addres
			s.addAddress(a);
			//dao
			StudentDaoImpl dao=new StudentDaoImpl();
			System.out.println(dao.admitStudent(s, cName));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
