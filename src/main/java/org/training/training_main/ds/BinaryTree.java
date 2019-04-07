package org.training.training_main.ds;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree
{
    //Root of the Binary Tree
    Node root;
 
    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. */
 
    /* returns true if given search tree is binary
     search tree (efficient version) */
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
    
    void printInOrder(Node node) {
		if(node==null)
			return;
		printInOrder(node.left);
		System.out.print(node.data+" ");
		printInOrder(node.right);
	}
    class Found{
    	boolean a;
    	boolean b;
    }
    
    Node findCommonParentUtil(Node node,int n1,int n2) {
    	if (node == null) 
            return null; 
  
        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (node.data == n1 || node.data == n2) 
            return node; 
  
        // Look for keys in left and right subtrees 
        Node left_lca = findCommonParentUtil(node.left, n1, n2); 
        Node right_lca = findCommonParentUtil(node.right, n1, n2); 
  
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca!=null && right_lca!=null) 
            return node; 
  
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
 
    }
    
    Node findCommonParent(int a , int b) {
    	return findCommonParentUtil(this.root,a,b);
	}
    
    public void print(Node root,int w,int h,Map<Integer,ENode> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(w)){
        	ENode e = new ENode(root, h); 
            map.put(w,e);
        }else {
        	ENode e = map.get(w);
        	if(h<e.h) {
        		map.put(w, new ENode(root, h));
        	}
        }
        print(root.left,w-1,h+1,map);
        print(root.right,w+1,h+1,map);
        
    }

	public void topView(Node root) {
        Map<Integer,ENode> map = new TreeMap<Integer,ENode>();
        print(root,0,0,map);
        Set<Integer> keySet = map.keySet();
        //Collections.sort(keySet);
        for(Integer k : keySet){
            ENode n = map.get(k);
            System.out.print(n.n.data+" ");
            // for(Node n : list){
            //     System.out.print(n.data+" ");    
            // }
        }
    }
	
	static class ENode{
		Node n;
		int h;
		
		public ENode(Node n,int h){
			this.n= n;
			this.h= h;
		}
	}
	
	public void spiralView(Node root) {
		Stack<Node> s1 = new  Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!(s1.isEmpty() && s2.isEmpty())) {
			while(!s1.empty()) {
				Node n = s1.pop();
				System.out.println(n.data);
				if(n.right!=null)
					s2.push(n.right);
				if(n.left!=null)
					s2.push(n.left);
			}
			while(!s2.empty()) {
				Node n = s2.pop();
				System.out.println(n.data);
				if(n.left!=null)
					s1.push(n.left);
				if(n.right!=null)
					s1.push(n.right);
			}
		}
	}
	
	public void rightView(Node root) {
		int h = 0;
		System.out.println("--Right view");
		Queue<Node> q= new LinkedList<>();
		q.add(root);
		int n = q.size();
		while(!q.isEmpty()) {
			n = q.size();
			while(n!=0) {
				Node no = q.poll();
				n--;
				if(n==0) {
					System.out.print(no.data+" ");
				}
				if(no.left!=null)
					q.add(no.left);
				if(no.right!=null)
					q.add(no.right);
			}
			h++;
		}
	}
}
	
