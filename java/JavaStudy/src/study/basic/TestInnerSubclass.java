package study.basic;

public class TestInnerSubclass extends TestInnerClass.InnerClass {
	public TestInnerSubclass(TestInnerClass ti) {
		ti.super("From another class");
	}
	
	public void test (){
		this.info();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInnerSubclass tis = new TestInnerSubclass(new TestInnerClass());
		tis.test();
	}

}
