package study.basic;

public class TestInnerClass {
	private String prop = "Outer class prop";
	
	public class InnerClass {
		private String prop = "Inner class prop";
		public InnerClass(String prop) {
			this.prop = prop;
		}
		public static final  String abc = "fdafd";
		public void info() {
			String prop = "Local prop";
			
			System.out.println(TestInnerClass.this.prop);
			System.out.println(this.prop);
			System.out.println(prop);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInnerClass ti = new TestInnerClass();
		ti.test();
		TestInnerClass.InnerClass fd = ti.new InnerClass("Hello");
		fd.info();
	}
	public void test() {
		InnerClass in = new InnerClass("Hello A");
		in.info();
	}
}
