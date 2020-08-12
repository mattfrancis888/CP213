package cp213;

import java.util.ArrayList;

/**
 * A simple linked sorted list structure of <code>T</code> objects. Only the
 * <code>T</code> value contained in the sorted list is visible through the
 * standard sorted list methods. Extends the <code>DoubleLink</code> class,
 * which already defines the front node, rear node, length, isEmpty, and
 * iterator.
 *
 * @author - your name here -
 * @author David Brown
 * @version 2019-01-26
 *
 * @param <T>
 *            this value structure value type.
 */
public class DoubleSortedList<T extends Comparable<T>> extends DoubleLink<T> {
	  public static void main(final String[] args) {
		  DoubleSortedList<Integer> list= new DoubleSortedList<Integer>();
		  list.insert(1);
		  list.insert(2);
		  list.insert(4);
		  list.insert(3);
		  list.insert(3);
		  list.clean();
		  System.out.println("INSERT AND CLEAN: ");
		  for(Integer val : list) {
			  System.out.println(val);
		  }
		  DoubleSortedList<Integer> list2= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list3= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list4= new DoubleSortedList<Integer>();
		  System.out.println("COMBINE: ");
		  list3.insert(1);
		  list3.insert(2);
		  list4.insert(2);
		  list2.combine(list3, list4);
		  for(Integer val : list2) {
			  System.out.println(val);
		  }
		  DoubleSortedList<Integer> list5= new DoubleSortedList<Integer>();
		  list5.insert(1);
		  list5.insert(3);
		  //list5.insert(1);
		  System.out.println("CONTAINS: " + list5.contains(1) );
		 System.out.println("COUNT: " + list5.count(1) );
		  System.out.println("FIND: " + list5.find(1) );
		  System.out.println("GET (INSERT INDEX): " + list5.get(0) );
		 System.out.println("INDEX: " + list5.index(1) );
		 
		  DoubleSortedList<Integer> list6= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list7= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list8= new DoubleSortedList<Integer>();
		  list6.insert(1);
		  list6.insert(2);
		  list7.insert(1);
		  list7.insert(2);
		  list8.insert(10);
		  //list7.insert(3);
		  System.out.println("INTERSECTION: ");
		  list8.intersection(list6, list7);
		  for(Integer val : list8) {
			  System.out.println(val);
		  }
		  System.out.println("IS IDENTICAL: " + list6.isIdentical(list7));
		  System.out.println("MAX: " + list6.max());
		  System.out.println("MIN: " + list6.min());
		  
		  DoubleSortedList<Integer> list9= new DoubleSortedList<Integer>();
		  
		  list9.insert(1);
		  list9.insert(2);
		  list9.insert(3);
		  list9.insert(2);
		  System.out.println("REMOVE:" + list9.remove(1));
		  for(Integer val : list9) {
			  System.out.println(val);
		  }

		  System.out.println("REMOVE FRONT");
		  list9.removeFront();
		  for(Integer val : list9) {
			  System.out.println(val);
		  }
		  System.out.println("REMOVE REAR");
		  list9.removeRear();
		  for(Integer val : list9) {
			  System.out.println(val);
		  }
		  DoubleSortedList<Integer> list10= new DoubleSortedList<Integer>();
		  list10.insert(1);
		  list10.insert(2);
		  list10.insert(2);
		  System.out.println("REMOVE MANY WITH NEW LIST");
		  list10.removeMany(2);
		  for(Integer val : list10) {
			  System.out.println(val);
		  }
		  
		  System.out.println("SPLIT ALTERNATE:");
		  DoubleSortedList<Integer> list11= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list12= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list13= new DoubleSortedList<Integer>();
		  list11.insert(1);
		  list11.insert(2);
		  list11.insert(3);
		  list11.splitAlternate(list12, list13);
		  for(Integer val : list12) {
			  System.out.println(val);
		  }
		  System.out.println("UNION:");
		  DoubleSortedList<Integer> list14= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list15= new DoubleSortedList<Integer>();
		  DoubleSortedList<Integer> list16= new DoubleSortedList<Integer>();
		  list15.insert(1);
		  list16.insert(2);
		  list16.insert(3);
		  list16.insert(3);
		  list14.union(list15, list16);
		  for(Integer val : list14) {
			  System.out.println(val);
		  }
	  }

    /**
     * Removes duplicates from this List. The list contains one and only one of
     * each value formerly present in this List. The first occurrence of each
     * value is preserved.
     */
    public void clean() {
	// your code here
    	ArrayList<T> cleanList = new ArrayList<T>();
    	DoubleNode<T> current = this.front;
    	DoubleNode<T> previous = current.getPrev();
        while (current != null) {
            if(cleanList.contains(current.getValue())){
                this.length -= 1;        
                if(current.getNext() == null) {
                	this.rear = previous;
                	previous.setNext(null);
                } else { 
                	previous.setNext(current.getNext());
                }
            } else {
            	cleanList.add(current.getValue());
                previous = current;
	        }
            current = current.getNext();
        }
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from
     * the source lists into this List, but the sorted order is preserved. The
     * source lists are empty when finished. NOTE: value must not be moved, only
     * nodes.
     *
     * @param source1
     *            The first list to combine with this List.
     * @param source2
     *            The second list to combine with this List.
     */
    public void combine(final DoubleSortedList<T> source1,
	    final DoubleSortedList<T> source2) {
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
     * Determines if this SortedList contains key.
     *
     * @param key
     *            The key value to look for.
     * @return true if key is in this SortedList, false otherwise.
     */
    public boolean contains(final T key) {
	// your code here
      	DoubleNode<T> current = this.front;
    	boolean found = false;
    	while(current != null) {
    		if(current.getValue().compareTo(key) == 0) {
    			found = true;
    			return found;
    		}
    		current = current.getNext();
    	}
    	return found;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key
     *            The value to look for.
     * @return The number of times key appears in this SortedList.
     */
    public int count(final T key) {
	// your code here
    	int count = 0;
    	DoubleNode<T> current = this.front;
    	
    	while(current != null) {	
			if(current.getValue().compareTo(key) == 0){
				count += 1;
			}	
    		current = current.getNext();
    	}
    	
    	return count;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key
     *            The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {
	// your code here
    	DoubleNode<T> current = this.front;

    	while(current != null) {
			if(current.getValue().compareTo(key) == 0 ){
				return key;
			}

    		current = current.getNext();
    	}
    	System.out.println("Failed to find key:" + key);
    	return null;
    }

    /**
     * Get the nth item in this SortedList.
     *
     * @param n
     *            The index of the item to return.
     * @return The nth item in this SortedList.
     * @throws ArrayIndexOutOfBoundsException
     *             if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {
	// your code here
    	DoubleNode<T> current = this.front;
    	if(current != null) {
	    	for(int i = 0; i < n; i++) {
	    		current = current.getNext();
	    	}
	    	return current.getValue();
    	}
    	return null;
    }

    /**
     * Finds the location of a value by key in list.
     *
     * @param key
     *            The value to search for.
     * @return The index of key in this SortedList, -1 otherwise.
     */
    public int index(final T key) {
	// your code here
    	DoubleNode<T> current = this.front;
    	int index = 0;
    	while(current != null) { 
			if(current.getValue().compareTo(key) == 0 ){
				return index;
			}	
    		index += 1;
    		current = current.getNext();
    	}
    	System.out.println("Key not found");
    	index = -1;
    	return index;
    }

    /**
     * Inserts value into this SortedList. Order is preserved.
     *
     * @param value
     *            The new value to insert into this SortedList.
     */
    public void insert(final T value) {
	// your code here
    	DoubleNode<T> current = this.front;
		DoubleNode<T> prev = this.front;	
		if (this.length == 0) {
			final DoubleNode<T> node = new DoubleNode<>(value,null,null);
			this.front = node;
			this.rear = node;
		}else {
			while(current.getValue().compareTo(value)<0 && current != this.rear) {
				//While node that you are traversing is less than input value 
				prev = current;
				current = current.getNext();
			}
			//Stop while loop when a node that you traversed is larger than input value
			if (current == this.rear &&
					current.getValue().compareTo(value) < 0){
				//if it's at rear
				final DoubleNode<T> node = new DoubleNode<>(value,current,null);
				this.rear.setNext(node);
				this.rear = node;
			}else {
				//In the middle of the list
				final DoubleNode<T> node = new DoubleNode<>(value,prev,current);
				current.setPrev(node);
				prev.setNext(node);
			}
		}
		this.length++;
    	
    }

    /**
     * Creates an intersection of two other Lists into this SortedList. Copies
     * value to this SortedList. left and right Lists are unchanged.
     *
     * @param left
     *            The first List to create an intersection from.
     * @param right
     *            The second List to create an intersection from.
     */
    public void intersection(final DoubleSortedList<T> left,
	    final DoubleSortedList<T> right) {
	// your code here
        DoubleNode <T> source1Node = left.front;
        T currentVal = null;
        
        T key = null;
        while (source1Node != null) {
            key = source1Node.getValue();
            currentVal = right.find(key);

            if(currentVal != null) {
                // Value exists in both source lists.
            	//Check current list for duplicating values
            	currentVal = this.find(key);

                if(currentVal != null) {
                   //Value does not appear in target list.
                	System.out.println("VALUE DOES NOT APPEAR IN TARGET LIST");
                    this.insert(currentVal);
                }
            }
            source1Node = source1Node.getNext();
        }

    }

    /**
     * Determines whether two lists are identical.
     *
     * @param that
     *            The list to compare against this SortedList.
     * @return true if this SortedList contains the same values in the same
     *         order as that, false otherwise.
     */
    public boolean isIdentical(final DoubleSortedList<T> that) {
	// your code here
    	boolean identical = false;
        if(this.getLength() != that.getLength()) {
        	identical = false;
        }
        else {
        	if(this.isEmpty() && that.isEmpty()) {
        		identical = true;
        	} else { 
	            DoubleNode<T> sourceNode = this.front;
	            DoubleNode<T> targetNode = that.front;
	
	            while(sourceNode !=null && sourceNode.getValue() == targetNode.getValue()) {
	            	sourceNode = sourceNode.getNext();
	            	targetNode = targetNode.getNext();
	            }
	            if(sourceNode == null) {
	            	identical = true;
	            }
        	}
            
        }
        return identical;
    }

    /**
     * Finds the maximum value in this SortedList.
     *
     * @return The maximum value.
     */
    public T max() {
	// your code here
    	return this.rear.getValue();
    }

    /**
     * Finds the minimum value in this SortedList.
     *
     * @return The minimum value.
     */
    public T min() {
	// your code here
    	return this.front.getValue();
    }

    /**
     * Finds, removes, and returns the value in this SortedList that matches
     * key.
     *
     * @param key
     *            The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {
	// your code here
    	DoubleNode<T> current = this.front;
    	T value = null;
    	//Iterate list to remove node with key
    	while(current != null) {
			if(current.getValue().compareTo(key) == 0 ){
				value = current.getValue();
				break;
			}
			
    		current = current.getNext();
    		//Will be null if it loops everyhing and finds nothing
    	}
    	
    	DoubleNode<T> previous = current.getPrev();
    
                if (current == null) {
                    value = null;
                }else {
                    value = current.getValue();
                    this.length -= 1;    
                
                    if(previous == null) {
                       //Only 1 element on the list
                    	if(current.getNext() == null) {
                            this.front = null;
                            this.rear = null;
                        } else {
                        	//remove front
                            this.front = current.getNext();
                        }
                            
                    }else if(current.getNext() == null) {
                    	//Remove the end of the list/last element on the list
                        this.rear = previous;
                        previous.setNext(null); 
                    } else {
                    	//Any node in the middle of the list
                    	 previous.setNext(current.getNext());
                    }
                       
                  }
                        
                return value;

    }

    /**
     * Removes and returns the value at the front of the list.
     *
     * @return the value that has been removed.
     */
    public T removeFront() {
	// your code here
		T front = this.front.getValue();
		this.front = this.front.getNext();
		if (this.length == 1) {
			this.rear =null;
		}else {
			this.front.setPrev(null);
		}
		this.length--;
		return front;
    }

    /**
     * Finds and removes all values in this SortedList that match key.
     *
     * @param key
     *            The value to search for.
     */
    public void removeMany(final T key) {
	// your code here
      	DoubleNode<T> current = this.front;
    	DoubleNode<T> prev = this.front;
    
     	while(current != null) {
			if(current.getValue().compareTo(key) == 0 ){
				
				//Remove current
				
				this.length -= 1;
				//Only element in the list
				if(this.isEmpty()) {
					this.front = null;
					this.rear = null;
				} else { 
					//If any node in the middle of list
					prev.setNext(current.getNext());
					
					//Update rear if want to remove last element in the list
					if (this.rear == current) {
						this.rear = prev;
					}
					
				}
			} else {
				//Update prev if we are not removing current
				prev = current;
			}
			current = current.getNext();
	
    	}
				
    }

    /**
     * Removes and returns the value at the rear of the list.
     *
     * @return the value that has been removed.
     */
    public T removeRear() {
	// your code here
    	T rear = this.rear.getValue();
		this.rear = this.rear.getPrev();
		if (this.length == 1) {
			this.front =null;
		}else {
			this.rear.setNext(null);
		}
		this.length--;
		return rear;
    }

    /**
     * Splits the contents of this List into the target Lists. Moves nodes only
     * - does not move value or call the high-level methods insert or remove.
     * this List is empty when done. The first half of this List is moved to
     * target1, and the last half of this List is moved to target2. If the
     * resulting lengths are not the same, target1 should have one more element
     * than target2.
     *
     * @param target1
     *            The first List to move nodes to.
     * @param target2
     *            The second List to move nodes to.
     */
    public void split(final DoubleSortedList<T> target1,
	    final DoubleSortedList<T> target2) {
	// your code here
    	int n = 0;
		DoubleNode<T> current = this.front;
		if (this.length%2 != 0) {
			n = this.length /2+1;
		}else{
			n= this.length/2;
		}if (n<2) {
			current.setNext(null);
			current.setPrev(null);
			target1.front = current;
			target1.rear = current;
			this.front = null;
			target1.length++;
		}else {
			this.front = this.front.getNext();
			this.front.setPrev(null);
			current.setNext(null);
			current.setPrev(null);
			target1.front = current;
			target1.rear = current;
			current= this.front;
			target1.length++;
			this.length--;

			while (this.length >=n) {
				this.front = this.front.getNext();
				if (this.front != null) this.front.setPrev(null);
				current.setNext(null);
				current.setPrev(target1.rear);
				target1.rear.setNext(current);
				target1.rear = current;
				current = this.front;
				target1.length++;
				this.length--;
			}
			this.front = this.front.getNext();
			if (this.front != null) this.front.setPrev(null);
			current.setNext(null);
			current.setPrev(null);
			target2.front = current;
			target2.rear = current;
			current= this.front;
			target2.length++;
			this.length --;
			while (this.length >0) {
				this.front = this.front.getNext();
				current.setNext(null);
				current.setPrev(target2.rear);
				target2.rear.setNext(current);
				target2.rear = current;
				current = this.front;
				target2.length++;
				this.length--;
			}
		}
		this.rear = null;
    }

    /**
     * Splits the contents of this List into the target Lists. Moves nodes only
     * - does not move value or call the high-level methods insert or remove.
     * this List is empty when done. Nodes are moved alternately from this List
     * to target1 and target2.
     *
     * @param target1
     *            The first List to move nodes to.
     * @param target2
     *            The second List to move nodes to.
     */
    public void splitAlternate(final DoubleSortedList<T> target1,
	    final DoubleSortedList<T> target2) {
	// your code here
    	while(!this.isEmpty()) {
    		target1.moveFrontToRear(this);
    		if(!this.isEmpty()) {
    			target2.moveFrontToRear(this);
    		}
    	}
    }

    /**
     * Creates a union of two other Lists into this SortedList. Copies value to
     * this list. left and right Lists are unchanged.
     *
     * @param left
     *            The first List to create a union from.
     * @param right
     *            The second List to create a union from.
     */
    public void union(final DoubleSortedList<T> left,
	    final DoubleSortedList<T> right) {
	// your code here
        DoubleNode<T> s1Node = left.front;
        while (s1Node != null) {
            T val = s1Node.getValue();
            if (this.find(val) == null) {
                this.insert(val);
            }
            s1Node = s1Node.getNext();
        }
        
        DoubleNode<T> s2Node = right.front;
        while (s2Node != null) {
            T val = s2Node.getValue();
            if (this.find(val) == null) {
                this.insert(val);
            }
            s2Node = s2Node.getNext();
        }
        return;
		//or
//		for(T node:left) {
//			this.insert(node);
//		} for (T node:right) {
//			this.insert(node);
//		}
    }
    
    private void moveFrontToRear(DoubleSortedList<T> source) {
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
