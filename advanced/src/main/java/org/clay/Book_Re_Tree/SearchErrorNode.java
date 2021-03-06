package org.clay.Book_Re_Tree;

/**
 * 一棵 BST，但是有两个节点交换了位置，使得这棵树不再是搜索二叉树，找到这两个错误节点并返回
 * 已知所有节点的值都不一致，
 *
 * 思路：BST的中序遍历肯定是一直升序，如果有两个值交换了位置，肯定会出现降序，
 * > 如果出现了两次降序，{1,2,3,4,5} -> {1,5,3,4,2}，则第一个错误的节点为第一次降序时较大的节点，第二个错误的节点为第二次降序时较小的节点，{5,3} {4,2} 所以第一个错误节点为5，第二个错误节点为2
 * > 如果出现了一次降序，{1,2,3,4,5} -> {1,2,4,3,5}，则两个错误节点就是发生降序时的两个节点；
 *
 * 总结：
 * > 第一个错误节点为第一次降序时较大的节点；
 * > 第二个错误节点为最后一次降序时较小的节点；
 *
 * 非递归的中序遍历中找即可；
 */
public class SearchErrorNode {
}
