package leetcode;

import junit.framework.Assert;

public class _Test2 {
	int i = 0;
	static int j = 0;
	
	private static void outerStaticMethod(Class<?> inClass){
		Amey.log("outerStaticmethod called by " + inClass.getName());
	}
	
	private void outerInstanceMethod(Class<?> inClass){
		Amey.log("outerInstanceMethod called by " + inClass.getName());
	}
	
	class InnerInstanceClass{
		public void display(){
			int h = j;
			outerStaticMethod(this.getClass());
		}
	}
	
	static class InnerStaticClass{
		int h = j;
		
		public void display(){
			outerStaticMethod(this.getClass());
		}
	}
	
	public static void main(String args[]){
		Integer a = 77;
		Integer b = 77;
		Integer x = 88888;
		Integer y = 88888;
		if(a==b)
			Amey.log("int less than 127 share ref");
		if((x==y))
			Amey.log("int more than 127 dont sshare ref");
		_Test2 t = new _Test2();
		_Test2.InnerInstanceClass instanceClass = t.new InnerInstanceClass();
		_Test2.InnerStaticClass staticClass = new _Test2.InnerStaticClass();
		
		instanceClass.display();
		staticClass.display();
		
	}
}

class Main{

}

/*
 * tet how u can call statc methods insdide outer class and if class variables are accessible 
 * onside inner static class
 * 
 * also, main is in different class than public class
 * 
 */


