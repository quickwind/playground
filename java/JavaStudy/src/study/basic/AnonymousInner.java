package study.basic;



/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

public class AnonymousInner
{
	public static abstract class Device
	{
		private String name;
		public abstract double getPrice();
		public Device(){}
		public Device(String name)
		{
			this.name = name;
		}
		//此处省略了name的setter和getter方法
		public void setName(String name)
		{
			this.name = name;
		}
		public String getName()
		{
			return this.name;
		}
	}
	public Device test(Device d)
	{
	System.out.println("购买了一个" + d.getName()
		+ "，花掉了" + d.getPrice());
	return d;
	}
	
	public Device test1() {
		return this.test(new Device("电子示波器")
		{
			public double getPrice()
			{
				return 67.8;
			}
		});
	}
	public static void main(String[] args) 
	{
		AnonymousInner ai = new AnonymousInner();
		//调用有参数的构造器创建Device匿名实现类的对象
		Device d1 = ai.test(new Device("电子示波器")
		{
			public double getPrice()
			{
				return 67.8;
			}
		});
		//调用无参数的构造器创建Device匿名实现类的对象
		Device d = new Device()
		{
			//初始化块
			{
				System.out.println("匿名内部类的初始化块...");
			}
			//实现抽象方法
			public double getPrice()
			{
				return 56.2;
			}
			//重写父类的实例方法
			public String getName()
			{
				return "键盘";
			}
		};
		System.out.println(d1.getName());
	}
}
