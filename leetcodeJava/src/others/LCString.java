package others;

import java.util.*;

public class LCString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	static final int hash(Object paramObject)
	  {
	    int i;
	    return paramObject == null ? 0 : (i = paramObject.hashCode()) ^ i >>> 16;
	  }
	
	static void getLCString(String str1, String str2){
	    int[][] dp = new int[str1.length()+1][str2.length()+1];
	    for(int i = 1;i < str1.length();i++){
	    	for(int j = 1;j < str2.length();j++){
	    		if(str1.charAt(i)==str2.charAt(j))
	    			dp[i][j] = dp[i-1][j-1]+1;
	    		else
	    			dp[i][j] = 0;
	    	}
	    }
	}
}
