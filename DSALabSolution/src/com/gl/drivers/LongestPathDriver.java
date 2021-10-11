package com.gl.drivers;

import java.util.ArrayList;
import java.util.Collections;




public class LongestPathDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(100);
		Node right = new Node(130);
		Node left = new Node(20);
		root.left = left;
		root.right = right;
		left.left = new Node(10);
		left.right = new Node(50);
		right.left = new Node(110);
		right.right = new Node(140);
		left.left.left = new Node(5);
		
		ArrayList<Integer> longestPath = findLongestPath(root);
		Collections.reverse(longestPath);
		
		for (int each : longestPath) {       
		    System.out.print(each);
		    System.out.print("->");
		}
		

	}

	// Function to find longest path in a binary tree 

	public static ArrayList<Integer> findLongestPath(Node root) {

		if (root == null) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output; // return blank array if root == null i.e no further tree exists
		}

		// recursively call findLongestPath on right node
		ArrayList<Integer> rightNode = findLongestPath(root.right);
		
		// recursively call findLongestPath on left node
				ArrayList<Integer> leftNode = findLongestPath(root.left);

		// Compare the size of array list and add the current node data accordingly
		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.data);
		} else {
			rightNode.add(root.data);
		}

		// if left Node array is greater then right then return left array and vice-versa
		return leftNode.size() > rightNode.size() ? leftNode : rightNode;

	}

}


class Node {

	public Node left;
	public Node right;
	public int data;


	Node(int data) {
		this.data = data;
	}

}