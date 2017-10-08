package org.clay.Chap1;

import java.util.LinkedList;


class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;

	public TreeNode(String val) {
		this.val = val;
	}
}

public class PrintBinaryTree {

	/**
	 * ������������ղ�����ӡ 
	 * ˼·��
	 * lastָ�룺��ʾ���ڴ�ӡ�ĵ�ǰ�е����ҽڵ�
	 * nLastָ�룺��Զָ����һ�е����ҽڵ㣬ԭ���ǣ�ÿ�α�����һ���ڵ㣬�Ͱ�nLastָ�������ҽڵ�
	 * ��nowָ��last��ʱ�򣬾�˵��nlast�Ѿ�ָ������һ�����ұߵĽڵ��ˣ��ð�last = nlast��ʱ���ˡ�
	 */
	public void PrintBinaryTree(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();

		queue.push(root);

		TreeNode last = root;
		TreeNode nLast = null;
		TreeNode now = null;

		while (!queue.isEmpty()) {

			now = queue.removeFirst(); // now�ʹ���ÿ��Ҫ��ջ��˳����Ϊlastָ�����Զ�ǵ�ǰ�е����һ���ڵ㣬����nowָ��last���ʹ���û����ˡ�
			System.out.print(now.val + " ,"); // ����ÿ�ε������ӵ�tmp�м����С�
			if (now.left != null) {
				queue.add(now.left);
				nLast = now.left;
			}
			if (now.right != null) {
				queue.add(now.right);
				nLast = now.right;
			}

			if (now == last) { // ��nowָ������last���ʹ�����һ�б������ˣ���ʱ��
										// ��һ�е����ݴ洢��res�У�Ȼ���tmp��ա�
				System.out.println();
				last = nLast;
			}
		}
	}

	public static void main(String[] args) {

		PrintBinaryTree pbt = new PrintBinaryTree();

		TreeNode root = new TreeNode("1");
		TreeNode node1 = new TreeNode("2");
		TreeNode node2 = new TreeNode("3");
		TreeNode node3 = new TreeNode("4");
		TreeNode node4 = new TreeNode("5");

		root.left = node1;
		root.right = node2;

		node1.left = node3;
		node1.right = node4;

		pbt.PrintBinaryTree(root);

	}

}
