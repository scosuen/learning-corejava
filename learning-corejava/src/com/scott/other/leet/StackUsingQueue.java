package com.scott.other.leet;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	private Queue<String> q1 = new LinkedList<String>();
	private Queue<String> q2 = new LinkedList<String>();

	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		
		s.push("111");
		s.push("222");
		s.push("333");
		s.push("444");
		
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

	public void push(String str) {
		while(!q1.isEmpty()) {
			q2.offer(q1.poll());
		}
		
		q1.offer(str);
		
		while (!q2.isEmpty()) {
			q1.offer(q2.poll());
		}
	}

	public String pop() {

		return q1.poll();
	}

	public boolean isEmpty() {

		return q1.isEmpty();
	}

}
