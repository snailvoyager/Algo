package DataStructures.Tree;

public class BinaryTree {

	static class Node{
		Object data;
		Node left;
		Node right;
		
		public Node(Object input) {
			this.data = input;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void inorderTraverse(Node node) {		//중위순회
		if(node == null)
			return;
		inorderTraverse(node.left);
		System.out.print(node.data + "->");
		inorderTraverse(node.right);
	}
	
	public static void preOrderTraverse(Node node) {	//전위순회
		if(node == null)
			return;
		System.out.print(node.data + "->");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}
	
	public static void postOrderTraverse(Node node) {	//후위순회
		if(node == null)
			return;
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.print(node.data + "->");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(0);
		Node nd1 = new Node(1);
		Node nd2 = new Node(2);
		Node nd3 = new Node(3);
		
		root.left = nd1;
		root.right = nd2;
		nd1.left = nd3;
		
		inorderTraverse(root);
		System.out.println();
		preOrderTraverse(root);
		System.out.println();
		postOrderTraverse(root);
		
	}

}
