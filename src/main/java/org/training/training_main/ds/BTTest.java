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
        Node s = tree.findCommonParent(3, 6);
        System.out.println("");
        System.out.println(s != null?s.data:"N");
	}
}
