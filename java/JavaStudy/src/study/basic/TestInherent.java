package study.basic;

public class TestInherent {
	public static class Base{
		public String name = "Base";
		public Base() {
			System.out.println("Started...");
			test();
		}
		
		public void test() {
			System.out.println("This method will be overrided by subclass" + name.length());
		}
	}
	
	public static class Child extends Base {
		public String name;
		public void test() {
			System.out.println(name.length());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c=new Child();
	}

}
