/**
 * Olivia Nye
 * 
 * Binary Search Tree
 * 
 * Intro to Algorithms Project 1 - Milestone 1
 * 
 * This class implements an Binary Search Tree. 
 * 
 *  */
package alg_BST_project1;


//import alg_AVL_project1.AVLTree.Node;

public class BSTree <E extends Comparable<? super E>> {
	
	
	protected Node root;
    protected int size;

    /**
     * Construct an empty BST
     */
    public BSTree() {
        // not necessary, but explicit stating root starts at null
        this.root = null;
        this.size = 0; //size is the total # of nodes in the tree
    }
    
    /**
     * A protected method to allow the insertion of new nodes into the BST.
     * By taking a Node as a parameter, we can write this method
     * recursively, continuing to call insert on subtrees until the element
     * can be inserted.
     * @param node the root of some subtree of this BST
     * @param element the element to insert into this subtree
     * @return root node of tree, after insertion of the element
     */
	protected Node Insert(Node node, E element) {
		
		if (node == null) {
			Node myNode = new Node(element);
            return myNode;
        }
		Node myNode = node;
        if ((int)element > (int)myNode.element) { 
            myNode.right = Insert(myNode.right, element);
        } else if ((int)element < (int)myNode.element) {
            myNode.left = Insert(myNode.left, element);
        }
        return myNode;
    }


    /**
     * A protected method to allow the removal of nodes from the BST.
     * By taking a Node as a parameter, we can write this method
     * recursively, continuing to call remove on subtrees until the element
     * is removed.
     * @param node the root of some subtree of this AVLTree
     * @param element the element to remove from this subtree
     * @return root node of tree, after removal of the element
     */
	protected Node Remove(Node node, E element) {

		Node myNode = node; 
		if (myNode == null) {
            //tree is empty. return node. same as returning null
            return node;
        }
        if (element.compareTo(myNode.element) > 0) {
            myNode.right = Remove(myNode.right, element);
        } else if (element.compareTo(node.element) < 0) {
            myNode.left = Remove(myNode.left, element);
        } else {
            //if you reached a leaf null and never found the element we're trying to remove. Tree has exhausted
            if (myNode.left == null && myNode.right == null) {
                return myNode;
            }
            if (myNode.left == null) {
                return myNode.right;
            } else if (myNode.right == null) {
                return myNode.left;
            } else {
                E temp = findMin(myNode.right);
                myNode.element = temp;
                myNode.right = Remove(myNode.right, temp);
            }
            
        }
        return node;
	}
	
    /**
     * protected method searches a BST for an indicated element, checks whether or not that element is in the tree
     * @param element the element to search for
     * @param node the root of the subtree to search in
     * @return true if this subtree contains the element, false otherwise
     */
	protected boolean contains(Node node, E element) {
		Node myNode = node;
        if (myNode == null) {
            return false;
        }
        if (element.compareTo(myNode.element) == 0) {
            return true;
        }
        if (element.compareTo(myNode.element) < 0) {
            return contains(myNode.left, element);
        } else {
            return contains(myNode.right, element);
        }
    }
	/**
     * Return the minimum element in the subtree rooted at node
     * @param node the root of the subtree
     * @return the minimum element in this subtree
     */	
	protected E findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    protected class Node {
        Node left;
        Node right;
        E element;

        /**
         * Construct a BSTree Node. At instantiation, each node has no
         * children and therefore a height of 0.
         * @param element the element that this node contains
         */
        public Node(E element) {
            this.left = null;
            this.right = null;
            this.element = element;
        }
    }
	
}
