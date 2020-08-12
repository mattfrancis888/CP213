package cp213;
/**
 * Implements a Binary Search Tree.
 *
 * @param <T> The data to store in the tree.
 */
public class AVL <T extends Comparable<T>> extends BST<T>{
		  
	    public TreeNode<T> root = null; 
	    
	    int height(TreeNode<T> N) { 
	        if (N == null) 
	            return 0; 
	  
	        return N.getHeight(); 
	    } 
	  
	  
	    public int max(int a, int b) { 
	        return (a > b) ? a : b; 
	    } 
	  
	    private TreeNode<T> rightRotate(TreeNode<T> y) { 
	    	TreeNode<T> x = y.getLeft(); 
	    	TreeNode<T> T2 = x.getRight(); 
	  
	        x.setRight(y); 
	        y.setLeft(T2); 
	  
	        y.updateHeight();
	        x.updateHeight();

	        return x; 
	    } 
	    private TreeNode<T> leftRotate(TreeNode<T> x) { 
	    	TreeNode<T> y = x.getRight(); 
	    	TreeNode<T> T2 = y.getLeft(); 
	   
	        y.setLeft(x); 
	        x.setRight(T2); 
	  
	        x.updateHeight();
	        y.updateHeight();
	  
	        // Return new root 
	        return y; 
	    } 
	  
	    // Get Balance factor of node N 
	    private int getBalanceFactor(TreeNode<T> N) { 
	        if (N == null) 
	            return 0; 
	  
	        return height(N.getLeft()) - height(N.getRight()); 
	    } 
	  
	    public TreeNode<T> insert(TreeNode<T> node, T key) { 
	  
	        /* 1. normal BST insertion */
	        if (node == null) 
	            return (new TreeNode<T>(key)); 
	  
	        if (key.compareTo(node.getData()) < 0) 
	            node.setLeft(insert(node.getLeft(), key)); 
	        else if (key.compareTo(node.getData()) > 0) 
	            node.setRight(insert(node.getRight(), key)); 
	        else // Duplicate keys are not allowed 
	            return node; 
	  
	        /* 2. Update height of the ancestor node */
	        node.updateHeight();
	  
	        /* 3. Balance factor to check if node becomes unbalanced*/
	        int balance = getBalanceFactor(node); 
	  
	        // If this node becomes unbalanced, then there 
	        // are 4 cases
	        
	        //Left Left Case 
	        if (balance > 1 && key.compareTo(node.getLeft().getData()) < 0 ) 
	            return rightRotate(node); 
	  
	        // Right Right Case 
	        if (balance < -1 && key.compareTo(node.getRight().getData()) > 0 ) 
	            return leftRotate(node); 
	  
	        // Left Right Case 
	        if (balance > 1 && key.compareTo(node.getLeft().getData()) > 0) { 
	            node.setLeft(leftRotate(node.getLeft())); 
	            return rightRotate(node); 
	        } 
	  
	        // Right Left Case 
	        if (balance < -1 && key.compareTo(node.getRight().getData()) < 0) { 
	            node.setRight(rightRotate(node.getRight())); 
	            return leftRotate(node); 
	        } 
	  
	        // return the unchanged node
	        return node; 
	    } 
	  

	    private void preOrder(TreeNode<T> node) { 
	        if (node != null) { 
	            System.out.print(node.getData() + " "); 
	            preOrder(node.getLeft()); 
	            preOrder(node.getRight()); 
	        } 
	    } 
	  
	    private void inOrder(TreeNode<T> node) { 
	        if (node != null) { 
	            
	        	inOrder(node.getLeft()); 
	            System.out.print(node.getData() + " "); 
	            inOrder(node.getRight()); 
	        } 
	    } 
	    
	    private void postOrder(TreeNode<T> node) { 
	        if (node != null) { 
	        	postOrder(node.getLeft()); 
	        	postOrder(node.getRight()); 
	            System.out.print(node.getData() + " "); 
	        } 
	    } 
	    
	    public static void main(String[] args) { 
	        AVL<Integer> tree = new AVL<Integer>(); 
	  
	        tree.insert(tree.root, 10); 
	        tree.root = tree.insert(tree.root, 20); 
	        tree.root = tree.insert(tree.root, 30); 
	        tree.root = tree.insert(tree.root, 40); 
	        tree.root = tree.insert(tree.root, 50); 
	        tree.root = tree.insert(tree.root, 25); 
	  
	        System.out.println("Preorder traversal: "); 
	        tree.preOrder(tree.root); 
	        System.out.println("");
	        System.out.println("Inorder traversal: ");
	        tree.inOrder(tree.root);
	        System.out.println("");
	        System.out.println("Postorder traversal: ");
	        tree.postOrder(tree.root);
	    } 
}
