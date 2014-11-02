package study.basic;

import java.util.ArrayList;

public class TestArray {
	static class A {
		public String name = null;
		public A(String name)  {
			this.name = name;
		}
	}

	public static void fun(A a) {
		a.name = "fdafd";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<A> lst = new ArrayList<>();
		lst.add(new A("Wallace"));
		lst.add(new A("Jane"));
		lst.add(new A("Emily"));
		for(A a: lst){
			System.out.println(a);
		}
		for(A a: lst) {
			a=new A("ABC");
			//lst.remove(0);
		}
		
		for(A a: lst){
			System.out.println(a);
		}
		
		A a = new A("Wallace");
		fun(a);
		System.out.println(a.name);
		String str = new String("abc");
		System.out.println(str.hashCode());
		System.out.println(System.identityHashCode(str));
	}

}
