package com.gl.services;

import java.util.Stack;

public class BalancingBrackets {
	
	// Declare Character type stack to add parenthesis
	private Stack<Character> stack;
	
	
	//Function to check if given parenthesis string is balanced or not.
	public boolean isBalancedBrackets(String string) {
		
		stack = new Stack<Character>();
		
		for (int i = 0; i < string.length(); i++) {

			char ch = string.charAt(i);

			if (ch == '[' || ch == '(' || ch == '{') {
				// push into stack if it is opening parenthesis
				stack.push(ch);
			} else if ((ch == ']' || ch == '}' || ch == ')') && (!stack.isEmpty())) {
				if (((char) stack.peek() == '(' && ch == ')') || ((char) stack.peek() == '{' && ch == '}') || ((char) stack.peek() == '[' && ch == ']')) {
					// pop from stack if it is closing bracket and equals to peek of stack
					stack.pop();
				} else {
					// return false if closing bracket do not matches peek of stack 
					return false;
				}
			} else {
				if ((ch == ']' || ch == '}' || ch == ')')) {
					// return false  since stack is empty and its a closing bracket
					return false;
				}
			}

		}
		// return true if stack is empty i.e  balancing brackets 
		return stack.isEmpty();
	}
	
	

}
