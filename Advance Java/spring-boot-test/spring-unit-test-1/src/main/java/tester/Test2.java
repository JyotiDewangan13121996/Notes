package tester;

public class Test2 {

	public static void main(String[] args) {
		byte x=-30;
		//30 --- 0001 1110
		//-30 ---1111....11... 1110 0010
		byte y=25;
		//x >>> y --- 0....0111 1111 = 7f =127
		//since its -ve number --take 2's complement
		//1......1 = -1
		System.out.println(x>>>y);

	}

}
