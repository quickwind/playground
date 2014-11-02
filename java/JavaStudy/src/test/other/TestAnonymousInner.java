package test.other;

import study.basic.*;

public class TestAnonymousInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonymousInner ai = new AnonymousInner();
		Object o = ai.test1();
		System.out.println(o);
		if(o instanceof AnonymousInner.Device) {
			AnonymousInner.Device d = (AnonymousInner.Device)o;
			System.out.println(d.getName());
		}
		
	}

}
