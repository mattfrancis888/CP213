package cp213;
import java.util.ArrayList;

/**
 * Implements a Binary Search Tree.
 *
 * - Matthew Francis -
 *
 * @version 2019-01-26
 *
 * @param <T> The data to store in the tree.
 */
public class BST<T extends Comparable<T>> {

    private int comparisons = 0;
    // Attributes.
    protected TreeNode<T> root = null;
    protected int size = 0;

    private boolean containsAux(TreeNode<T> current, final T key) {
    	//If empty
    	if (current == null || current.getData() == null) {
    		return false;
    	}
    	//if found
    	if (key == current.getData()) {
    		return true;
    	}
    	//Recursively iterate until we find
    	return ((key.compareTo(current.getData()) < 0) ? containsAux(current.getLeft(), key) : containsAux(current.getRight(),key));
    }
    
    /**
     * Determines if this BST contains key.
     *
     * @param key The key to search for.
     * @return true if this BST contains key, false otherwise.
     */
    public boolean contains(final T key) {

		// your code here
    	return containsAux(root, key);

    }

    /**
     * Determines whether two BSTs are identical.
     *
     * @param that The BST to compare this BST against.
     * @return true if this BST and that BST contain nodes that match in
     *         position, value, count, and height, false otherwise.
     */

    private boolean equalsAux(TreeNode<T> node1, TreeNode<T> node2){
    	if(node1 == null && node2 == null){
    		//Reached bottom of tree
    		return true;
    	}
    	else if(node1 != null && node2 != null) {
    		if (node1.getData().compareTo(node2.getData()) == 0) {
    			return true && equalsAux(node1.getLeft(),node2.getLeft()) && equalsAux(node1.getRight(),node2.getRight());
    		}
    		else {
    			return false;
    		}
    	}
    	//NOTE: MIGHT BE UNNECECARY
    	else {
    		return false;
    	}
    }
    
    public boolean equals(final BST<T> that) {

		// your code here

    	boolean equals = this.getSize() == that.getSize();
    	if (equals) {
    		equals = equalsAux(this.root,that.root);
    	}
    	return equals;

    }

    /**
     * Get number of comparisons executed by the {@code retrieve} method.
     *
     * @return comparisons
     */
    public int getComparisons() {
	return this.comparisons;
    }

    /**
     * Returns the height of the root node of this BST.
     *
     * @return height of root node, 0 if the root node is null.
     */
    public int getHeight() {

		// your code here
    	return this.root.getHeight();

    }

    /**
     * Returns the number of nodes in the BST.
     *
     * @return size of this BST.
     */
    public int getSize() {

		// your code here
    	return this.size;
    }

    /**
     * Inserts data into this BST.
     *
     * @param data Data to store.
     */
    public void insert(final T data) {

		// your code here
       	this.root = insertAux(this.root,data);
    	this.size += 1;

    }
    private TreeNode<T> insertAux(TreeNode<T> node,final T data) {
    	if (node == null) {
    		//Base Case: Add new node containing the value
    		node = new TreeNode<T>(data);
    	}
    	else if (node.getData().compareTo(data) > 0){
    		//General Case: Check left subtree
    		node.setLeft(this.insertAux(node.getLeft(), data));
    	}
    	else if (node.getData().compareTo(data) < 0){
    		//General case: Check right subtree
    		node.setRight(this.insertAux(node.getRight(), data));
    	}
    	else {
    		//Base Case: Node is already in the BST
    		node.incrementCount();
    	}
    	
    	node.updateHeight();
    	return node;
    }
    /**
     * Determines if this BST is empty.
     *
     * @return true if this BST is empty, false otherwise.
     */
    public boolean isEmpty() {

		// your code here
    	return this.getSize() == 0;

    }

    /**
     * Determines if this BST is a valid BST; i.e. a node's left child data is
     * smaller than its data, and its right child data is greater than its data.
     * The height of a node is equal to the maximum of the heights of its two
     * children (missing child nodes have a height of 0), plus 1.
     *
     * @return true if this BST is a valid BST, false otherwise.
     */
    private boolean isValidAux(TreeNode<T> node) {
    	if (node == null) {
    		return true;
    	}
    	if (node.getLeft() != null && node.getLeft().getData().compareTo(node.getData()) >= 0) {
    		//BST Violation, node on left subtree is >= root node
    		return false;
    	}
    	if (node.getRight() != null && node.getRight().getData().compareTo(node.getData()) <= 0) {
    		//BST Violation, node on right subtree is <= root node
    		return false;
    	}
    	
    	//handle heights
    	if(node.getLeft() != null && node.getRight() != null) {
    		//Parent node needs to be equal to child's height + 1
    		if(node.getHeight() != Math.max(node.getLeft().getHeight(), node.getRight().getHeight()) + 1) {
    			return false;
    		}
    	}
    	else if (node.getLeft() == null) {
    		//if parent has no left child
    		//Parent node needs to be equal to right's child height + 1
    		return (node.getRight() != null && node.getHeight() != node.getRight().getHeight() + 1);
    	}
    	else if(node.getRight() == null) {
    		//if parent has no right child
    		//Parent node needs to be equal to left's child height + 1
    		return (node.getLeft() != null && node.getHeight() != node.getLeft().getHeight() + 1);
    	}
    	else {
    		return true && isValidAux(node.getLeft()) && isValidAux(node.getRight());
    	}
    	//NOTE: MIGHT BE UNNECECARY 
    	return true;
    }
    
    public boolean isValid() {

		// your code here
    	boolean valid = this.isValidAux(this.root);
    	return valid;

    }

    /**
     * Resets the comparison count to 0.
     */
    public void resetComparisons() {
	this.comparisons = 0;
	return;
    }

    /**
     * Retrieves the node whose data matches key. Returning a TreeNode gives
     * access to the node data and count.
     *
     * @param key The key to look for.
     * @return A DataCountPair object that contains the data that matches key
     *         and its count, null otherwise.
     */
    private TreeNode<T> retrieveAux(TreeNode<T> current, final T key){
    	if (current == null || current.getData() == null) {
    		return null;
    	}
    	if (key == current.getData()) {
    		this.comparisons+=1;
    		return current;
    	}
    	this.comparisons+=1;
    	return ((key.compareTo(current.getData()) < 0) ? retrieveAux(current.getLeft(), key) : retrieveAux(current.getRight(),key));
    }
    
    public TreeNode<T> retrieve(final T key) {
		// your code here
    	TreeNode<T> value = retrieveAux(root,key);
    	return value;
    }

    /**
     * Returns an array of tree nodes from a linked data structure. Not thread
     * safe as it assumes contents of data structure are not changed by an
     * external thread during the copy loop. If data elements are added or
     * removed by an external thread while the data is being copied to the
     * array, then the declared array size may no longer be valid. The array
     * contents are in data order.
     *
     * @return the tree nodes of a bst as an array of nodes.
     */
    @SuppressWarnings("unchecked")
    public final TreeNode<T>[] toArray() {
	final ArrayList<TreeNode<T>> queue = new ArrayList<>();
	this.toArrayAux(this.root, queue);
	return queue.toArray(new TreeNode[queue.size()]);
    }

    /**
     * Performs an inorder traversal of a tree copying nodes to a queue.
     *
     * @param node  a TreeNode
     * @param queue temporary structure to hold nodes
     */
    private final void toArrayAux(final TreeNode<T> node,
	    final ArrayList<TreeNode<T>> queue) {
	if (node != null) {
	    this.toArrayAux(node.getLeft(), queue);
	    queue.add(node);
	    this.toArrayAux(node.getRight(), queue);
	}
    }

    /**
     * Returns the height of a given TreeNode.
     *
     * @param node The TreeNode to determine the height of.
     * @return The value of the height attribute of node, 0 if node is null.
     */
    protected int nodeHeight(final TreeNode<T> node) {

		// your code here
    	int height = 0;
    	if (node != null) {
    		height = node.getHeight();
    	}
    	return height;


    }

}
