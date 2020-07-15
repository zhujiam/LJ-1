package com.jm.java;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Node {
  private int value;
  private List<Node> children;
  
  public Node(int value) {
  	this.value = value;
  	children = new LinkedList<Node>();
  }
  
  /**
   * 将节点插入指定位置
   * @param root
   * @param node
   * @param parent
   */
  public void addNode(Node root, Node node, int parent) {
  	if (root == null) {
  		root = node;
  	}else {
  		Node p = findNode(root, parent);
  		if (p != null) {
  			p.children.add(node);
  			//System.out.println("Add successfully!");
  		}else {
  			System.out.println("Can not find parent!");
  		}
  	}
  }
  
  /**
   * 根据节点的值查找该节点.
   * @param root
   * @param value
   * @return Node
   */
  public Node findNode(Node root, int value) {
  	Queue<Node> q = new LinkedList<Node>();
  	if (root == null) {
  		return null;
  	}else {
  		q.offer(root);
  		Node temp;
  		while (!q.isEmpty()) {
  			temp = q.poll();
  			if (temp.value == value) {
  				return temp;
  			}else {
  				for (Node e:temp.children) {
  					q.offer(e);
  				}
  			}
  		}
  		return null;
  	}
  }
  
  /**
   * 层级遍历所有元素.
   * @param root
   * @return List<List<Integer>>
   */
  public List<List<Integer>> levelOrder(Node root){
  	if (root == null) {
  		return null;
  	}else {
  		//System.out.println("Begin scan...");
  		List<List<Integer>> result = new LinkedList<List<Integer>>();
    	List<Integer> temp = new LinkedList<Integer>();
    	Queue<Node> q = new LinkedList<Node>();
    	q.offer(root);
    	Node node;
    	int count = 1;
    	while (!q.isEmpty()) {
    		//System.out.println(count);
    		if (count > 0) {
    			node = q.poll();
    			for (Node e:node.children) {
  					q.offer(e);
  				}
    			temp.add(node.value);
    			count--;
    		}else {
    			//System.out.println(temp);
    			List<Integer> l = new LinkedList<Integer>();
    			l.addAll(temp);
    			result.add(l);
    			temp.clear();
    			count = q.size();
    		}
    	}
    	result.add(temp);
    	return result;
  	}
  }
  
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
}
