package cp213;
/**
 * Implements a Binary Search Tree.
 *
 * @version 
 *
 * @param <T> The data to store in the tree.
 */
public class PopularityTree<T extends Comparable<T>> extends BST<T> {
	   public static void main(String[] args) { 
		   PopularityTree<Integer> tree = new PopularityTree<Integer>(); 
		   tree.insert(1);
		   tree.insert(2);
		   tree.insert(3);
		   tree.insert(3);
		   System.out.println(tree.root);
		   System.out.println(tree.root.getLeft().getRight());
		   
	    } 
	   
	public TreeNode<T> rightRotation(TreeNode<T> y) {

		TreeNode<T> x = y.getLeft();
		TreeNode<T> node = x.getRight();
		
		x.setRight(y);
		
		y.setLeft(node);
		y.updateHeight();
		
		x.updateHeight();
		
		return x;
		
		
	}

	public TreeNode<T> leftRotation(TreeNode<T> z) {

		TreeNode<T> y = z.getRight();
		TreeNode<T> node = y.getLeft();
		
		y.setLeft(z);
		
		z.setRight(node);
		z.updateHeight();
		
		y.updateHeight();
		
		return y;
	}
	
	public void insert(final T data) {
   	 	root = insertAux(data,root);
   	 	
   	 	return;
	}
	
    private TreeNode<T> insertAux(final T data, TreeNode<T> root ) {
	    if (root == null) {
	   		this.size = this.size + 1;
	   		root = new TreeNode<T>(data);
	   		
	   		return root;
	    }
	    
		if (data.compareTo(root.getData()) > 0) {
           	root.setRight(insertAux(data, root.getRight()));
           	
           	if (root.getCount() < root.getRight().getCount()) {
           		root = leftRotation(root);
           		root.updateHeight();
           	}
		}
		
        else if (data.compareTo(root.getData()) < 0) {	
       		root.setLeft(insertAux(data,root.getLeft()));
	       	
       		if (root.getCount() < root.getLeft().getCount()) {
	       		root = rightRotation(root);
	       		root.updateHeight();
	       	}
        }
		
        else {
        	root.incrementCount();
        }
		
		root.updateHeight();

		return root;
    }
}