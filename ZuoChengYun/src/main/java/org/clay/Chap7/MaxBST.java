package org.clay.Chap7;

/**
 * 一棵二叉树，每个节点的值都不一样， 求最大的二叉搜索子树
 * @author clay
 */
public class MaxBST {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 以节点node为头的树中，最大的搜索二叉子树只可能来自一下两种情况。
	 *  1.如果来自node左子树上的最大搜索二叉子树是以node.left为头的；来自node右子树的最大搜索二叉树是以node.right为头的；
	 *  node左子树上的最大搜索二叉子树的最大值小于node。value；node右子树的最大搜索二叉子树的最小值大于node.value,
	 *  那么以节点node为头的整棵树都是搜索二叉树。
	 *  
	 *  2.如果不满足第一中情况，说明节点node为头的整颗树不能连成搜索二叉树。这种情况下，
	 *  以node为头的树上的最大搜索二叉子树来自node的左子树上的最大搜索二叉子树和来自右子树上的最大搜索二叉子树之间，节点较多的那个。
	 * 
	 * 过程如下：
	 * 1，整个过程是二叉树的后序遍历。（左右根）
	 * 2，遍历到当前节点记为cur时，先遍历cur的左子树收集4个信息，分别是左子树上最大搜索二叉子树的头节点（IBST） ，
	 * 节点数（ISize）,最小值（IMin）,最大值（IMax）.
	 * 	再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头节点（RBST） ，节点数（RSize）,最小值（RMin）,最大值（RMax）.
	 * 
	 * 3, 根据步骤2收集的信息，判断是否满足第一种情况，如果满足第一种情况就返回cur，如果满足第二种情况，就返回IBST和RBST中较大的一个。
	 * 4，可以使用全局变量的方式实现步骤2中收集节点数，最大和最小的情况。
	 * */
	public TreeNode findMaxBST(TreeNode head){
		// 记录节点数，最大值，最小值
		int[] record = new int[3];
		return posOrder(head, record);
	}
	
	private TreeNode posOrder(TreeNode head, int[] record) {
		if(head == null){
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;  //最小值赋值为最大的数字
			record[2] = Integer.MIN_VALUE;  //最大值赋值为最小的数字
			return null;
		}
		
		int val = head.val;// 取出传入头节点的值
		TreeNode left = head.left;// 左子树的头节点
		TreeNode right = head.right;// 右子树的头节点
		
		TreeNode lBST = posOrder(left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		
		TreeNode rBST = posOrder(right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		
		//根据左右子树递归信息，判断当前结点为根的子树性质:如果是二叉搜索树则更新最大二叉搜索子树的信息；
		//如果不是，则返回左右子树中的最大二叉搜索子树的信息
		if(left == lBST && right == rBST && val > lMax && val < rMin){
			record[0] = lSize + rSize + 1;
			return head;
		}
		record[0] = Math.max(lSize, rSize);
		
		return lSize > rSize ? lBST : rBST;
	}
}
