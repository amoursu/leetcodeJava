package medium;

import java.util.Stack;

public class P150_EvaluateRPN {
    public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(String token : tokens){
			switch(token){
			case "+":stack.push(stack.pop() + stack.pop());break;
			case "-":stack.push(-stack.pop() + stack.pop());break;//attention
			case "*":stack.push(stack.pop() * stack.pop());break;
			case "/":int operand1 = stack.pop();int operand2 = stack.pop();
			         stack.push(operand2 / operand1);break;
			default:stack.push(Integer.parseInt(token));
			}
		}
    	return stack.pop(); 
    }
    
    public static void main(String[] args){
    	String[] tokens = {"2", "1", "+", "3", "*"};
    	System.out.println(new P150_EvaluateRPN().evalRPN(tokens));
    }
}