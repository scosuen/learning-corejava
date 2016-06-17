package com.scott.algorithm.binarytree;

import java.util.Stack;

public class DepthFirstSearch {
	
	public static void main(String[] args) {
		Node head = Node.example();
		System.out.println("Max number:" + test1(head));
		
	}
	
	public static int test1 (Node head) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(head);
		
		int maxNumber = 0;
		
		Node temp;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.println(temp.getValue());
			if (maxNumber < Integer.valueOf(temp.getValue()))
				maxNumber = Integer.valueOf(temp.getValue());
			
			if (temp.getRightChild() != null)
				stack.push(temp.getRightChild());
			if (temp.getLiftChild() != null) 
				stack.push(temp.getLiftChild());
			
		}
		
		return maxNumber;
	}

}
