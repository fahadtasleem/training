package org.training.training_main.ds;

public class Node {
	int data;
	Node left;
	Node right;
	
	public Node() {
		
	}
	
	public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
