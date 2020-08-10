package tester;

public class TestInterface {

	public static void main(String[] args) {
		B b1=new B();//direct ref
		A ref=new B();//in direct ref --up casting
		A ref2=new A() {
			
			@Override
			public void show() {
				System.out.println("2");
				
			}
		};
		ref.show();
		ref2.show();

	}

}
