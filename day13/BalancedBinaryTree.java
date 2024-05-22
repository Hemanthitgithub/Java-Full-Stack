package day13programs;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		val = x;
	}
}

public class BalancedBinaryTree{
	
	public boolean isBalanaced(TreeNode root) {
		return checkheight(root)!= -1;
	}
	private int checkheight(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int leftHeight = checkheight(node.left);
				if(leftHeight == -1)
					return -1;
		int rightHeight = checkheight(node.right);
				if(rightHeight == -1)return -1;
		if(Math.abs(leftHeight - rightHeight)>1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
	

	public static void main(String[] args) {
	
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.left.left.left = new TreeNode(6);
	BalancedBinaryTree tree = new BalancedBinaryTree();
	System.out.println("Is the tree balanced? " +tree.isBalanaced(root));
	}
}

	
	
	
	
		