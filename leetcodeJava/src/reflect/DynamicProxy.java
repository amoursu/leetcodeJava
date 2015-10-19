package reflect;

import java.lang.reflect.*;

interface Subject{
	public String f(String name, int age);
}

class RealSubject implements Subject{
	public String f(String name, int age){
		return name+","+age;
	}
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj = null;
    
    public Object bind(Object obj){
    	this.obj = obj;
    	return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(this.obj, args);
	}
	
}

public class DynamicProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MyInvocationHandler handler = new MyInvocationHandler();
        Subject sub = (Subject)handler.bind(new RealSubject());
        System.out.println(sub.f("fuck", 24));
	}

}
