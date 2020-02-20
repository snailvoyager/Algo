package HackerRank.Easy;

import java.util.Scanner;

public class HeightofaBinaryTree {
	
	static class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

	public static int height(Node root) {
      	// Write your code here.
        int result = depth(root, -1);

        return result;
    }

    public static int depth(Node cur, int d){
        if(cur == null)
            return d;
        d++;
        int left = depth(cur.left, d);
        int right = depth(cur.right, d);

        return left > right ? left : right;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	

}
