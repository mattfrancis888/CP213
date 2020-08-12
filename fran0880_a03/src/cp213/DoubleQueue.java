package cp213;


/**
 * A simple linked queue structure of <code>T</code> objects. Only the
 * <code>T</code> value contained in the queue is visible through the standard
 * queue methods. Extends the <code>DoubleLink</code> class, which already
 * defines the front node, rear node, length, isEmpty, and iterator.
 *
 * @author - your name here -
 * @author David Brown
 * @version 2019-01-26
 *
 * @param <T>
 *            this data structure value type.
 */
public class DoubleQueue<T> extends DoubleLink<T> {

    /**
     * Combines the contents of the left and right Queues into the current
     * Queue. Moves nodes only - does not move value or call the high-level
     * methods insert or remove. left and right Queues are empty when done.
     * Nodes are moved alternately from left and right to this Queue.
     *
     * @param source1
     *            The front Queue to extract nodes from.
     * @param source2
     *            The second Queue to extract nodes from.
     */
	
	  public static void main(final String[] args) {
		  DoubleQueue<String> queue= new DoubleQueue<String>();
		  DoubleQueue<String> queue2= new DoubleQueue<String>();
		  DoubleQueue<String> queue3= new DoubleQueue<String>();
		  queue.insert("Hi");
		  queue.insert("Bye");
		  queue2.insert("Matt");
		  queue2.insert("Cool");
		  queue3.insert("Bye");
		  queue3.insert("Lol");
		  queue3.insert("Hehe");
		 queue.remove();
		 queue.combine(queue2, queue3);
		 queue.split(queue2, queue3);
		  for( String node : queue2) {
			  System.out.println(node);  
		  }
//		  for( String node : queue3) {
//			  System.out.println(node);  
//		  }
//		  System.out.println("split :");
//		  queue.split(queue2, queue3);
//		  for( String node : queue2) {
//			  System.out.println(node);  
//		  }
		 // System.out.println(queue.remove());
	  }

	  
    public void combine(final DoubleQueue<T> source1,
	    final DoubleQueue<T> source2) {
	// your code here
    	
    	while(!source1.isEmpty() || !source2.isEmpty()) {
    		if(!source1.isEmpty()) {
    			if(this.isEmpty()) {
    				//Empty list 
    				this.front = source1.front;
    				this.rear = source1.front;
    				source1.front = source1.front.getNext();
    			} else {
	    			this.rear.setNext(source1.front);
	    			this.rear = source1.front;
	    			source1.front = source1.front.getNext();
    			}
    			
	    		this.length += 1;
	    		source1.length -= 1;
    	}if(!source2.isEmpty()) {
    		if(this.isEmpty()) {
    			this.front = source2.front;
    			this.rear = source2.front;
    			source2.front = source2.front.getNext();
    		} else {
    			this.rear.setNext(source2.front);
    			this.rear = source2.front;
    			source2.front = source2.front.getNext();
    		}
    		
    		this.length += 1;
    		source2.length -= 1;
    	}
    }
   }

    /**
     * Adds value to the rear of the queue. Increments the queue size.
     *
     * @param value
     *            The value to added to the rear of the queue.
     */
    public void insert(final T value) {
	// your code here
    	if (this.getLength() == 0) {
    		this.front = new DoubleNode<T>(value, this.rear, null);
    		this.rear = this.front;
    	} else {
    		DoubleNode<T> temp = this.rear;
    		this.rear =  new DoubleNode<T>(value, this.rear, null);
    		temp.setNext(this.rear);
    
    	}
    	this.length += 1;
    }

    /**
     * Returns the front value of the queue and removes that value from the
     * queue. The next node in the queue becomes the new front node. Decrements
     * the queue size.
     *
     * @return The value at the front of the queue.
     */
    public T remove() {
	// your code here
    	this.length -= 1;
    	DoubleNode<T> removedNode = this.front;
    	if(this.getLength() > 0) {
    		this.front = this.front.getNext();
    		this.front.setPrev(null);
    	} else { 
    		this.front = null;
    		this.rear = null;
    	}
    	
    	return removedNode.getValue();
    }

    /**
     * Splits the contents of the current Queue into the left and right Queues.
     * Moves nodes only - does not move value or call the high-level methods
     * insert or remove. this Queue is empty when done. Nodes are moved
     * alternately from this Queue to left and right.
     *
     * @param target1
     *            The first Queue to move nodes to.
     * @param target2
     *            The second Queue to move nodes to.
     */
    public void split(final DoubleQueue<T> target1,
	    final DoubleQueue<T> target2) {
	// your code here
    	while(!this.isEmpty()) {
    		target1.moveFrontToRear(this);
    		if(!this.isEmpty()) {
    			target2.moveFrontToRear(this);
    		}
    	}
   }
    
    private void moveFrontToRear(DoubleQueue<T> source) {
    	DoubleNode<T> node = source.front;
    	source.length -= 1;
    	source.front = source.front.getNext();
    	if(source.isEmpty()) {
    		source.rear = null;
    	}
    	if(this.isEmpty()) {
    		this.front = node;
    	} else {
    		//current rear, to new node
    		this.rear.setNext(node);
    	}
    	this.rear = node;
    	this.rear.setNext(null);
    	this.length += 1;
    }
}
