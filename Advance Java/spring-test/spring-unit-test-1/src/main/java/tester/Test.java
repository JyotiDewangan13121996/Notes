package tester;

public class Test {

	public static void main(String[] args) {
		short s1=15;
		
		short s2=25;
		short s3=0b0000_1111;
		short s4=0b0001_1001;
		System.out.println(s1+" "+s2+" "+s3+" "+s4);
	/*	s1=-15;
		s2=-25;
		 s3=0b1111_0001;
		s4=0b1110_0111;
		System.out.println(s1+" "+s2+" "+s3+" "+s4);*/
		System.out.println("s1&s2 "+(s1&s2));
		System.out.println("s1|s2 "+(s1|s2));
		System.out.println("~s1 "+(~s1));
		System.out.println("s1^s2 "+(s1^s2));
		
		
		System.out.println("s1 << 2 "+(s1<<2));
		System.out.println("s1 >> 2 "+(s1>>2));
	//	s1=-15;
		System.out.println("s1 << 2 "+(s1<<2));
		System.out.println("s1 >> 2 "+(s1>>2));
		System.out.println("s1 >>> 2 "+(s1>>>2));
		byte b1=-7;
		System.out.println("b1 << 2 "+(b1<<2));
		System.out.println("b1 >> 2 "+(b1>>2));
		//-7 ---7 & its 2's complement
		//1111 1000
		//signed right shift by 2
		//1111 1110
		//since its 1 -ve no --take 2's comple.
		//0000 0001 +1 --> 1000 0010 = -2
		System.out.println("b1 >>> 2 "+(byte)(b1>>>2));
		
	}

}
