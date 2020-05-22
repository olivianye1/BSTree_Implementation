/*
 * Olivia Nye
 * 
 * Tester for Binary Search Tree
 * 
 * Intro to Algorithms Project 1 - Milestone 1
 * 
 * This class uses unit testing to test the BSTree class. 
 * Note that build path must use Junit 4 for proper functioning.
 */


package alg_BST_project1;

import static org.junit.Assert.*;
import org.junit.Test;

import alg_BST_project1.BSTree;

public class BST_Tester {
	
	@Test
	public void testInsert() { //building the following tree should invoke all possible Insertion cases 
		BSTree<Integer> myTree = new BSTree<Integer>();
		myTree.root = myTree.Insert(myTree.root, 19);
		myTree.root = myTree.Insert(myTree.root, 20);
		myTree.root = myTree.Insert(myTree.root, 8);
		myTree.root = myTree.Insert(myTree.root, 2);
		myTree.root = myTree.Insert(myTree.root, 22);
		assertEquals(true, myTree.contains(myTree.root, 8));
		
	}
	
	@Test
	public void testRemoveInvalid() { //try to remove a node that's not in the tree
		BSTree<Integer> myTree = new BSTree<Integer>();
		myTree.Insert(myTree.root,19);
		myTree.Insert(myTree.root, 32);
		myTree.Insert(myTree.root, 4); 
		myTree.Insert(myTree.root, 56);
		myTree.Insert(myTree.root, 18);
		myTree.Insert(myTree.root, 41);
		myTree.Insert(myTree.root, 1); 
		myTree.Insert(myTree.root, 10);
		myTree.Insert(myTree.root, 0);
		myTree.Insert(myTree.root, 2); 
		myTree.Insert(myTree.root, 24);
		myTree.Insert(myTree.root, 29);
		myTree.Insert(myTree.root, 71);
		myTree.Insert(myTree.root, 92);

		myTree.Remove(myTree.root, 800);
		assertEquals(false, myTree.contains(myTree.root, 800));
	}
	@Test
	public void testRemoveLeaf() { //remove a leaf 
		BSTree<Integer> myTree = new BSTree<Integer>();
		myTree.Insert(myTree.root, 19);
		myTree.Insert(myTree.root, 32);
		myTree.Insert(myTree.root, 4); 
		myTree.Insert(myTree.root, 56);
		myTree.Insert(myTree.root, 18);
		myTree.Insert(myTree.root, 41);
		myTree.Insert(myTree.root, 1); 
		myTree.Insert(myTree.root, 10);
		myTree.Insert(myTree.root, 0);
		myTree.Insert(myTree.root, 2); 
		myTree.Insert(myTree.root, 24);
		myTree.Insert(myTree.root, 29);
		myTree.Insert(myTree.root, 71);
		myTree.Insert(myTree.root, 92);
			
		myTree.Remove(myTree.root,  92);
		assertEquals(false, myTree.contains(myTree.root, 92));
		}
	
	@Test
	public void testRemoveRoot() { //remove the original root
		BSTree<Integer> myTree = new BSTree<Integer>();
		myTree.Insert(myTree.root, 19);
		myTree.Insert(myTree.root, 32);
		myTree.Insert(myTree.root, 4); 
		myTree.Insert(myTree.root, 56);
		myTree.Insert(myTree.root, 18);
		myTree.Insert(myTree.root, 41);
		myTree.Insert(myTree.root, 1); 
		myTree.Insert(myTree.root, 10);
		myTree.Insert(myTree.root, 0);
		myTree.Insert(myTree.root, 2); 
		myTree.Insert(myTree.root, 24);
		myTree.Insert(myTree.root, 29);
		myTree.Insert(myTree.root, 71);
		myTree.Insert(myTree.root, 92);
				
		myTree.Remove(myTree.root,  19);
		assertEquals(false, myTree.contains(myTree.root, 19));
	}
	@Test
	public void testRemoveMiddleNode() {//remove a middle node
		BSTree<Integer> myTree = new BSTree<Integer>();
		myTree.Insert(myTree.root, 19);
		myTree.Insert(myTree.root, 32);
		myTree.Insert(myTree.root, 4); 
		myTree.Insert(myTree.root, 56);
		myTree.Insert(myTree.root, 18);
		myTree.Insert(myTree.root, 41);
		myTree.Insert(myTree.root, 1); 
		myTree.Insert(myTree.root, 10);
		myTree.Insert(myTree.root, 0);
		myTree.Insert(myTree.root, 2); 
		myTree.Insert(myTree.root, 24);
		myTree.Insert(myTree.root, 29);
		myTree.Insert(myTree.root, 71);
		myTree.Insert(myTree.root, 92);

		myTree.Remove(myTree.root, 24);
		assertEquals(false, myTree.contains(myTree.root, 24));
	}

	

	@Test
	public void testLeftChild() {
		BSTree<Integer> myTree1 = new BSTree<Integer>();
			myTree1.root = myTree1.Insert(myTree1.root, 8);
			myTree1.root = myTree1.Insert(myTree1.root, 4);
			myTree1.root = myTree1.Insert(myTree1.root, 10);
			assertTrue(myTree1.root.left.element == 4);
	}

	@Test
	public void testRightChild() {
		BSTree<Integer> myTree1 = new BSTree<Integer>();
			myTree1.root = myTree1.Insert(myTree1.root, 8);
			myTree1.root = myTree1.Insert(myTree1.root, 4);
			myTree1.root = myTree1.Insert(myTree1.root, 10);
			assertTrue(myTree1.root.right.element == 10);
	}
	
	@Test
	public void testRightLeftChild() {
		BSTree<Integer> myTree1 = new BSTree<Integer>();
			myTree1.root = myTree1.Insert(myTree1.root, 8);
			myTree1.root = myTree1.Insert(myTree1.root, 4);
			myTree1.root = myTree1.Insert(myTree1.root, 10);
			myTree1.root = myTree1.Insert(myTree1.root, 9);
			assertTrue(myTree1.root.right.left.element == 9);
	}
	

}
