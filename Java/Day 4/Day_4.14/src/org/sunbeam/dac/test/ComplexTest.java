package org.sunbeam.dac.test;

import java.util.Scanner;

import org.sunbeam.dac.complex.Complex;

public class ComplexTest {
	static Scanner sc = new Scanner(System.in);
	private Complex c1 = new Complex();

	public void acceptRecord() {
		System.out.print("Real Number	:	");
		this.c1.setReal(sc.nextInt());
		System.out.print("Imag Number	:	");
		this.c1.setImag(sc.nextInt());
	}

	public void printRecord() {
		System.out.println("Real Number	:	" + this.c1.getReal());
		System.out.println("Imag Number	:	" + this.c1.getImag());
	}

	public static int menuList() {
		System.out.println("0.Exit");
		System.out.println("1.Accept Record");
		System.out.println("2.Print Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
}
