package tester;

public class Test3 {

	public static void main(String[] args) {
		byte x=-30;
		//30 --- 0001 1110
		//-30 --- 1110 0010 (by taking 2's complement)
		byte y=25;
		//x >> y --- 11111111
		//since its -ve number --take 2's complement
		//0000 0001 = -1 (retain -ve sign)
		System.out.println(x>>y);

	}

}
