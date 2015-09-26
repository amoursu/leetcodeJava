package others;

/**
 * 给定一个字符串，要求去掉首部和尾部的空格，字符串中间的空格连续出现的只保留一个。
 * @author zhouyan
 *
 */
public class meituanExample {
	public String formatString(String sourceString) {
		char[] str = sourceString.toCharArray();
		int new_str_end=0;
        boolean keepspace=false;
 
        for(int i=0;i<str.length;i++){
            if(str[i]!=' '){
                str[new_str_end++]=str[i];
                keepspace=true;
            }else{
                if(keepspace){
                    str[new_str_end++]=str[i];
                    keepspace=false;
                }
            }
        }
        
        return new String(str).substring(0, new_str_end-1);
    }
	
    static String division(String a, String b){
    	return null;
    }
	
	public static void main(String[] args){
		System.out.println(Math.ceil(2.1));
//		meituanExample test = new meituanExample();
//		System.out.println(test.formatString(" I love    you  "));
//		System.out.println(test.formatString(" I love    you  ").length());
	}
}
