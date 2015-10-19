package hard;

class A{
	public void f(){
		System.out.println("A");
	}
}

class B extends A{
	public void f(){
		System.out.println("B");
	}
	public void g(){
		
	}
}

public class Main {
    public static void main(String[] args){ 
    	int x = 1;
    	int y = 2;
    	swap1(x,y);
    	swap2(x,y);
    }
    
    static void swap1(int x, int y){
    	System.out.println(x+","+y);
    	x = x + y;
    	y = x - y;
    	x = x - y;
    	System.out.println(x+","+y);
    }
    
    static void swap2(int x, int y){
    	System.out.println(x+","+y);
    	x = x ^ y;
    	y = x ^ y;
    	x = x ^ y;
    	System.out.println(x+","+y);
    }
    
    static long getGCD(long a, long b){
    	while(a % b != 0){
    		long temp = a % b;
    		a = b;
    		b = temp;
    	}
    	return b;
    }
}
