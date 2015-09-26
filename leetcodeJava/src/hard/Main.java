package hard;

import java.util.*;

public class Main {
    public static void main(String[] args){
    	Scanner scan = new Scanner(System.in);
    	int p = scan.nextInt();
    	int q = scan.nextInt();
    	int l = scan.nextInt();
    	int r = scan.nextInt();
    	Set<Integer> set1 = new HashSet<Integer>();
    	Set<Integer> set2 = new HashSet<Integer>();
    	
    	for(int i=0;i<p;i++){
    		int a = scan.nextInt();
    		int b = scan.nextInt();
    		for(;a<=b;a++)
    			set1.add(a);
    	}
    	for(int i=0;i<q;i++){
    		int c = scan.nextInt();
    		int d = scan.nextInt();
    		for(;c<=d;c++)
    			set2.add(c);
    	}
    	int count = 0;
    	for(int i = l;i<=r;i++){
    		for(int s : set2){
    			if(set1.contains(s+i)){
    				count ++;
    				break;
    			}
    		}
    		
    	}
    	
    	System.out.println(count);
        scan.close();
    }
}
