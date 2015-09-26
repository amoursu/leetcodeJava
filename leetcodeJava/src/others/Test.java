package others;

import java.util.*;

public class Test {
	
	public static void f(List<String> list, String str){
		list.add("a");
		list.add("b");
		list = new ArrayList<String>();
		list.add("c");
		str = "2";
	}
	
	public static void main(String[] args){ 
		List<String> list = new ArrayList<String>();
		String str = "1";
		f(list,str);
		for(String s : list)
			System.out.print(s);
		System.out.println(str);
	}
}
