package com.ysh.java.basement.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree<String> bt = new BinaryTree<String>("根节点");
		BinaryTree.TreeNode tn1 = bt.addNode(bt.root(), "第二层左子结点", true);
		BinaryTree.TreeNode tn2 = bt.addNode(bt.root(), "第二层右子结点", false);
		BinaryTree.TreeNode tn3 = bt.addNode(tn2, "第三层左子结点", true);

		List<BinaryTree.TreeNode> list1 = new ArrayList<BinaryTree.TreeNode>();
		list1 = bt.inTraverse();
		System.out.println("inorder traverse");
		for (BinaryTree.TreeNode node : list1)
			System.out.print(node.data + " ");

		List<BinaryTree.TreeNode> list2 = new ArrayList<BinaryTree.TreeNode>();
		list2 = bt.preTraverse();
		System.out.println("\n preorder traverse");
		for (BinaryTree.TreeNode node : list2)
			System.out.print(node.data + " ");
		List<BinaryTree.TreeNode> list3 = new ArrayList<BinaryTree.TreeNode>();
		list3 = bt.levelTraverse();
		System.out.println("\n level traverse");
		for (BinaryTree.TreeNode node : list3)
			System.out.println(node.data + " ");
	}
}