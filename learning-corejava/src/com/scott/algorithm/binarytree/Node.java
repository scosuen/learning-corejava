package com.scott.algorithm.binarytree;

public class Node {

	private String value;
	private Node liftChild;
	private Node rightChild;
	
	public Node (String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLiftChild() {
		return liftChild;
	}

	public void setLiftChild(Node liftChild) {
		this.liftChild = liftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public boolean isLeaf () {
		if (getLiftChild() == null && getRightChild() == null)
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return getValue();
	}
	
	public static Node example () {
		Node head = new Node("3");
		
		head.setLiftChild(new Node("7"));
		head.setRightChild(new Node("9"));
		
		head.getLiftChild().setLiftChild(new Node("1"));
		head.getLiftChild().setRightChild(new Node("5"));
		
		head.getLiftChild().getRightChild().setLiftChild(new Node("3"));
		
		head.getRightChild().setRightChild(new Node("2"));
		
		return head;
	}

}
