
package org.learn.Question;

import org.learn.PrepareTree.Node;

public class PrintNodesKDistFromLeaf {

	private static void printNodes(Node root, int distance,int index, int[] data, boolean[] isVisitedBefore) {
		if(null == root) {
			return;
		}		
		data[index] = root.data;
		isVisitedBefore[index] = false;		
		if(root.left == null && root.right == null &&
				index - distance  >= 0 && isVisitedBefore[index-distance] == false) {
			System.out.printf(" %d ",data[index-distance ]);
			isVisitedBefore[index-distance] = true;
		} else if(distance > 0) {	
			index++;
			printNodes(root.left, distance,index, data, isVisitedBefore);
			printNodes(root.right, distance,index, data, isVisitedBefore);
		}
		return;
	}	
	
	public static void printNodesKDistFromLeaf(Node root, int distance) {
		int data[]= new int[1024];
		boolean visit[]= new boolean[1024];
		printNodes(root, distance, 0, data, visit);
	}
}
