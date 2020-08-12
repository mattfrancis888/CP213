package cp213;

import java.util.ArrayList;

/**
 * Implements a Binary Search Tree.
 *
 *
 * @param <T> The data to store in the tree.
 */
public class BST<T extends Comparable<T>> {

	private int comparisons = 0;
	// Attributes.
	protected TreeNode<T> root = null;
	protected int size = 0;

	/**
	 * Determines if this BST contains key.
	 *
	 * @param key The key to search for.
	 * @return true if this BST contains key, false otherwise.
	 */
	public boolean contains(final T key) {

		T value = this.retrieve(key).getData();
		if (value != null) 
			return true;
		else
			return false;
	}

	/**
	 * Determines whether two BSTs are identical.
	 *
	 * @param that The BST to compare this BST against.
	 * @return true if this BST and that BST contain nodes that match in
	 *         position, value, count, and height, false otherwise.
	 */

	public boolean equals(final BST<T> that) {
		boolean eq = true;
		if (this.size != that.size)
			eq  = false;
		else
			eq = this.equals_aux(this.root, that.root);
		return eq;

	}

	private boolean equals_aux(final TreeNode<T> node1, TreeNode<T> node2) {
		boolean result;
		if (node1 == null && node2 == null){
			result = true;
		}else if ((node1 !=  null) && (node2 !=  null) && 
				(node1.getData() == node2.getData()) && (node1.getHeight() == node2.getHeight())){
			result = this.equals_aux(node1.getLeft(), node2.getLeft())
					&& this.equals_aux(node1.getRight(), node2.getRight());
		}else {
			result = false;
		}
		return result;
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

		if (this.root == null)
			return 0;
		else
			return getHeight(this.root);
	}
	
	private int getHeight(TreeNode<T> node) {
	    if (node == null) {
	        return 0;
	    }

	    int lefth = getHeight(node.getLeft());
	    int righth = getHeight(node.getRight());

	    if (lefth > righth) {
	        return lefth + 1;
	    } else {
	        return righth + 1;
	    }
	}

	/**
	 * Returns the number of nodes in the BST.
	 *
	 * @return size of this BST.
	 */
	public int getSize() {

		return this.size;

	}

	/**
	 * Inserts data into this BST.
	 *
	 * @param data Data to store.
	 */
	public void insert(final T data) {

		this.root = this.insertAux(this.root, data);
	}

	private TreeNode<T> insertAux(TreeNode<T> node, T data){
		if (node == null) {
			node = new TreeNode<>(data);
			this.size++;
		}else if (node.getData().compareTo(data) >0) {
			node.setLeft(this.insertAux(node.getLeft(), data));
		}else if (node.getData().compareTo(data) < 0) {
			node.setRight(this.insertAux(node.getRight(), data));
		} else if(node.getData().compareTo(data)==0)
			node.incrementCount();
		node.updateHeight();
		return node;
	}
	/**
	 * Determines if this BST is empty.
	 *
	 * @return true if this BST is empty, false otherwise.
	 */
	public boolean isEmpty() {

		if (this.root != null)
			return false;
		else
			return true;

	}

	/**
	 * Determines if this BST is a valid BST; i.e. a node's left child data is
	 * smaller than its data, and its right child data is greater than its data.
	 * The height of a node is equal to the maximum of the heights of its two
	 * children (missing child nodes have a height of 0), plus 1.
	 *
	 * @return true if this BST is a valid BST, false otherwise.
	 */
	public boolean isValid() {

		return true;
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
	public TreeNode<T> retrieve(final T key) {

		TreeNode<T> node = this.root;
		TreeNode<T> value = null;

		while (node != null && value == null){

			if (node.getData().compareTo(key)>0){
				this.comparisons++;
				node = node.getLeft();
			}else if (node.getData().compareTo(key)<0){
				this.comparisons++;
				node = node.getRight();
			}else if (node.getData().equals(key)){
				value = node;
				this.comparisons++;
			}
		}
		return node;
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

		if (node == null)
			return 0;
		else
			return getHeight(node);
	}
	
	public void preorder() {
		preorder(this.root);
	}
	private void preorder(TreeNode<T> root) {
	    if(root !=  null) {
	   //Visit the node by Printing the node data  
	      System.out.printf("%d ",root.getData());
	      preorder(root.getLeft());
	      preorder(root.getRight());
	    }
	  }
	
}


