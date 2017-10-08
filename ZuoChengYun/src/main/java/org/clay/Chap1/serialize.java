package org.clay.Chap1;

import java.util.ArrayList;

/**
 * �������л��ͷ����л�
 * @author clay
 */
public class serialize {

	/**
	 * ���л�- ǰ��
	 */
	public void serialize(TreeNode root, StringBuilder builder){
		
		if(root == null){
			builder.append("#!");
		}else{
			builder.append(root.val + "!");
			serialize(root.left, builder);
			serialize(root.right, builder);
		}
	}
	
	/**
	 * ͨ��ǰ��������������з������ɶ�����
	 * 	 * 				A
	 *  	B				C
	 * D		E					F
	 * 
	 * ABD##E##C#F##
	 * 
	 * ��ArrayList��ԭ���ǿ���ֱ��remove��һ��Ԫ�أ���������ݹ�
	 */
	public TreeNode createBinaryTree(ArrayList<String> data){
	
		String d = data.get(0);
		TreeNode node;
		
		if(d.equals("#")){
			node = null;
			data.remove(0);
			return node;
		}
		
		node = new TreeNode(d);
		data.remove(0);
		node.left = createBinaryTree(data);
		node.right = createBinaryTree(data);
		
		return node;
	}
	
	public static void main(String[] args) {
		
		TreeNode nodeA = new TreeNode("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		TreeNode nodeD = new TreeNode("D");
		TreeNode nodeE = new TreeNode("E");
		
		nodeA.left = nodeB;
		nodeA.right = nodeC;
		
		nodeB.left = nodeD;
		nodeB.right = nodeE;
		
		
		serialize ss = new serialize();
		
		StringBuilder sb = new StringBuilder();
		
		ss.serialize(nodeA, sb);
		
		System.out.println(sb.toString());
	}
	
}
