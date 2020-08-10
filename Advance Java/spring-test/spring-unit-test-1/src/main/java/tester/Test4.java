package tester;

public class Test4 {

	public static void main(String[] args) {
		byte x=-7;
		//7 -- 0000 0111
		//-7 -- 1111 1001
		byte y=2;
		//x >>> y ---0011....1111 1110
		//since its -ve number --take 2's complement
		//0000 0001 + 1=-2
		System.out.println((byte)(x>>>y));

	}

}
