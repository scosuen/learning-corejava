package com.scott.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		Node head = Node.example();
		System.out.println(test2(head));

	}

	public static int test2(Node head) {
		int maxNumber = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.println(tempNode.getValue());
			if (maxNumber < Integer.valueOf(tempNode.getValue()))
				maxNumber = Integer.valueOf(tempNode.getValue());

			if (tempNode.getLiftChild() != null)
				queue.add(tempNode.getLiftChild());
			if (tempNode.getRightChild() != null)
				queue.add(tempNode.getRightChild());
		}

		return maxNumber;
	}

}
