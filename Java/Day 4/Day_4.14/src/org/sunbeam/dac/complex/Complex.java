package org.sunbeam.dac.complex;

public class Complex 
{
	private int real;
	private int imag;
	public Complex() 
	{
		this(0,0);
	}
	public Complex(int real, int imag) 
	{
		this.real = real;
		this.imag = imag;
	}
	public int getReal() {
		return real;
	}
	public void setReal(int real) {
		this.real = real;
	}
	public int getImag() {
		return imag;
	}
	public void setImag(int imag) {
		this.imag = imag;
	}
	@Override
	public String toString()
	{
		return "Complex [real=" + real + ", imag=" + imag + "]";
	}
}
