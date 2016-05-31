package com.scott.other.leet;

import java.util.Stack;

public class QueueUsingStacks {
	
	private Stack<String> s1 = new Stack<String>();
	private Stack<String> s2 = new Stack<String>();
	
	public static void main(String[] args) {
		QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
		
		queueUsingStacks.put("1111");
		queueUsingStacks.put("2222");
		queueUsingStacks.put("3333");
		
		while (!queueUsingStacks.isEmpty()) {
			System.out.println(queueUsingStacks.pop());
		}
		
	}
	
	public void put (String str) {
		while (!s1.empty()) {
			s2.push(s1.pop());
		}
		
		s1.push(str);
		
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public String pop () {
		if (!s1.isEmpty())
			return s1.pop();
			
		return null;
	}
	
	public boolean isEmpty () {
		return s1.isEmpty();
	}

}

