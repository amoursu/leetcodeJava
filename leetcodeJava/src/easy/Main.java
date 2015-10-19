package easy;

import java.lang.reflect.*;
import java.util.*;

class A{
	private String name;
	private int age;
	public A(int age,String name){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "["+name+", "+age+"]";
	}
	public void f(){
		this.toString();
	}
}

public class Main {
    public static void main(String[] args) {
    	System.out.println(A.class.getClassLoader().getClass().getName());
    }
}
