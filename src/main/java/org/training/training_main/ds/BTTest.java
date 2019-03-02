package org.training.training_main.ds;

public class BTTest {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.left.left.left = new Node(6);
        tree.printInOrder(tree.root);
        Node s = tree.findCommonParent(2, 7);
        System.out.println("");
        System.out.println(s != null?s.data:"N");
        
        tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.right = new Node(5); 
        tree.root.left.right.right.right = new Node(6); 
        System.out.println("Following are nodes in top view of Binary Tree");  
        tree.topView(tree.root);  
	}
}
