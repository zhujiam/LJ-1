package com.jm.java;

import java.util.List;
import java.util.Scanner;

/**
 * 构建多叉树.
 * @author M
 *
 * 2020年7月15日
 */
public class Solution {

	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		Node tree;
		// 初始化
		int N = in.nextInt();
		int root = in.nextInt();
		tree = new Node(root);
		in.nextLine();
		String str;
		String[] arr;
		for (int i = 0; i < N; i++) {
			str = in.nextLine();
			arr = str.split(" ");
			for (int j = 1; j < arr.length; j++) {
				tree.addNode(tree, new Node(Integer.parseInt(arr[j])), Integer.parseInt(arr[0]));
			}
		}
		
		// 遍历输出
		List<List<Integer>> levelOrder = tree.levelOrder(tree);
		//System.out.println("root: " + tree.getValue() + ", size:" + levelOrder.size());
		
		for (int i = 0; i < levelOrder.size(); i++) {
			for (int j = 0; j < levelOrder.get(i).size(); j++) {
				System.out.print(levelOrder.get(i).get(j));
				if (j < levelOrder.get(i).size() - 1)
					System.out.print(", ");
			}
			System.out.println();
		}
		in.close();
	}
}
