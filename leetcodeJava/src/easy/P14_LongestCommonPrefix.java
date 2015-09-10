package easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author zhouyan
 *
 */
public class P14_LongestCommonPrefix {
//    public String longestCommonPrefix(String[] strs) {
//        if(strs == null || strs.length==0)return "";
//        if(strs.length==1)return strs[0];
//        String shortStr = strs[0];
//        for(String str : strs)
//        	if(str.length()<shortStr.length())
//        		shortStr = str;
//        String prefix = "";
//        for(int i = 0;i < shortStr.length();i++){
//        	for(String str : strs)
//                if(str.charAt(i)!=shortStr.charAt(i))
//                	return prefix;
//            prefix += shortStr.charAt(i);
//        }
//        return prefix;
//    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)//indexof() is good!!
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
    
    public static void main(String[] args){
    	String a = "abcdefs";
    	String b = "ab";
    	System.out.println(a.indexOf(b));
    }
}
