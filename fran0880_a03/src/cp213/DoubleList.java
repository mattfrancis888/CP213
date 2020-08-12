package cp213;

import java.util.ArrayList;

/**
 * A simple linked list structure of <code>T</code> objects. Only the
 * <code>T</code> value contained in the list is visible through the standard
 * list methods. Extends the <code>DoubleLink</code> class, which already
 * defines the front node, rear node, length, isEmpty, and iterator.
 *
 * @author - your name here -
 * @author David Brown
 * @version 2019-01-26
 *
 * @param <T>
 *            this data structure value type.
 */
public class DoubleList<T extends Comparable<T>> extends DoubleLink<T> {
	  public static void main(final String[] args) {
		  DoubleList<String> list= new DoubleList<String>();
		  list.append("Hi");
		  list.append("Hi");
		  list.clean();
		  DoubleList<String> list2= new DoubleList<String>();
		  DoubleList<String> list3= new DoubleList<String>();
		  list2.append("list2");
		  list2.append("list22");
		  list3.append("list3");
		  list.combine(list2, list3);
		  for( String node : list) {
			  System.out.println(node);  
		  }
		  System.out.println("Contains: " + list.contains("list2"));
		  System.out.println("Count: " + list.count("list2"));
		  System.out.println("Find: " + list.find("list2"));
		  System.out.println("Get: " + list.get(0));
		  System.out.println("Index: " + list.index("Hi"));
		  list.insert(0, "INSERTED");
  	  list.insert(-list.length, "INSERTED1");
//		  list.insert(list.length, "INSERTED2");
		  for( String node : list) {
			  System.out.println(node);  
		  }
		  System.out.println("Is Identical: " + list.isIdentical(list2));
		  DoubleList<String> listIdentical1= new DoubleList<String>();
		  DoubleList<String> listIdentical2 = new DoubleList<String>();
		  System.out.println("Is Identical: " + listIdentical1.isIdentical(listIdentical2));
		  DoubleList<Integer> listNum = new DoubleList<Integer>();
		  listNum.append(1);
		  listNum.append(2);
		  
		  System.out.println("Max: " + listNum.max());
		  System.out.println("Min: " + listNum.min());
		  listNum.append(5);
		  listNum.remove(5);
		 
		 
		  listNum.append(3);
		  listNum.prepend(0);
		  listNum.append(6);
		  listNum.append(6);
		  listNum.removeMany(6);
		  listNum.removeFront();
		  listNum.reverse();
		  for( Integer node : listNum) {
			  System.out.println(node);  
		  }
		  DoubleList<Integer> listNum2 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum3 = new DoubleList<Integer>();
		  //listNum.split(listNum2, listNum3); //fix
		  listNum.splitAlternate(listNum2, listNum3);
		  System.out.println("Split alternate:");
		  for( Integer node : listNum2) {
			  System.out.println(node);  
		  }
		  DoubleList<Integer> listNum4 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum5 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum6 = new DoubleList<Integer>();
		  listNum6.append(1);
		  listNum6.append(2);
		  listNum6.append(3);
		  listNum4.append(1);
		  listNum5.append(2);
		  listNum5.append(3);
		  listNum6.union(listNum4, listNum5);
		  System.out.println("Union:");
		  for( Integer node : listNum6) {
			  System.out.println(node);  
		  }
		  
		  System.out.println("Split:");
		  DoubleList<Integer> listNum7 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum8 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum9 = new DoubleList<Integer>();
		  listNum7.append(1);
		  listNum7.append(2);
		  listNum7.append(3);
		  listNum7.split(listNum8, listNum9);
		  for( Integer node : listNum8) {
			  System.out.println(node);  
		  }
		  
		  System.out.println("Interseciton:");
		  DoubleList<Integer> listNum10 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum11 = new DoubleList<Integer>();
		  DoubleList<Integer> listNum12 = new DoubleList<Integer>();
		  listNum10.append(1);
		  listNum10.append(2);
		  listNum11.append(2);
		  listNum11.append(1);
		  listNum11.append(3);
		  listNum12.intersection(listNum10, listNum11);
		  for( Integer node : listNum12) {
			  System.out.println(node);  
		  }
	  }

    /**
     * Appends value to the rear of this List.
     *
     * @param value
     *            The value to append.
     */
    public void append(final T value) {
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
     * the source lists into this List. The source lists are empty when
     * finished. NOTE: value must not be moved, only nodes.
     *
     * @param source1
     *            The first list to combine with this List.
     * @param source2
     *            The second list to combine with this List.
     */
    public void combine(final DoubleList<T> source1,
	    final DoubleList<T> source2) {
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
     * Determines if this List contains key.
     *
     * @param key
     *            The key value to look for.
     * @return true if key is in this List, false otherwise.
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
     * @return The number of times key appears in this List.
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
    	System.out.println("Failed to find key: " + key);
    	return null;
    }

    /**
     * Get the nth item in this List.
     *
     * @param n
     *            The index of the item to return.
     * @return The nth item in this List.
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
     * Finds the first location of a value by key in this List.
     *
     * @param key
     *            The value to search for.
     * @return The index of key in this List, -1 otherwise.
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
     * Inserts value into this List at index i. If i greater than the length of
     * this List, append value to the end of this List. Accepts negative values:
     * -1 is the rear, -2 is second from the end, etc.
     *
     * @param i
     *            The index to insert the new value at.
     * @param value
     *            The new value to insert into this List.
     */
    public void insert(int n, final T value) {
	// your code here
     	
    	 if(n <= -this.length) {
    		 //used for when index input is greather than current lenght
    		 //eg input is -300 and length is -(1)
             this.prepend(value);
    	 }else if(n > this.length - 1) {
             this.append(value);
    	 }else {
//             if(n < 0) {
//            	 //used for when index input -x and the lenght is also -x;
//            	 // input of -3 and length of -(3)
//                 n = this.getLength() + n;  // 3 - 3 = 0
//                 //thus will be put in front later
//                 //TODO: make (n <= this.lenght )in if(n < -this.length)
//             }
          
            DoubleNode<T> current = this.front;
         	DoubleNode<T> previous = current.getPrev();
         	int c = 0;
    	 
             while(c < n) {
                 previous = current;
                 current = current.getNext();
                 c += 1;
             }

             if(previous == null) {
                 this.front = new DoubleNode<T>(value, previous, current);
             }else {
                 previous.setNext(new DoubleNode<T>(value, previous, current));
             }
             this.length += 1;
    	 }        		 
        		 
    }

    /**
     * Creates an intersection of two other Lists into this List. Copies value
     * to this List. Source Lists are unchanged.
     *
     * @param source1
     *            The first List to create an intersection from.
     * @param source2
     *            The second List to create an intersection from.
     */
    public void intersection(final DoubleList<T> source1,
	    final DoubleList<T> source2) {
        DoubleNode<T> curr1 = source1.front;
        DoubleNode<T> curr2 = source2.front;
        while ((curr1 != null) && (curr2 != null)){
            if ((curr1.getPrev() != null) && (curr1.getValue().compareTo(curr1.getPrev().getValue()) == 0)){
                curr1 = curr1.getNext();
            }else {
                while (curr2 != null) {
                    if ((curr2.getPrev() != null) && (curr2.getValue().compareTo(curr2.getPrev().getValue()) == 0)) {
                        curr2 = curr2.getNext();
                    }else {
                        if (curr1.getValue().compareTo(curr2.getValue()) == 0) {
                            this.append(curr1.getValue());
                            curr2 = null;
                        }else {
                            curr2 = curr2.getNext();
                        }
                    }
                }
                curr1 = curr1.getNext();
                curr2 = source1.front;
            }
        }


    }

    /**
     * Determines whether two lists are identical.
     *
     * @param that
     *            The list to compare against this List.
     * @return true if this List contains the same values in the same order as
     *         that, false otherwise.
     */
    public boolean isIdentical(final DoubleList<T> that) {
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
     * Finds the maximum value in this List.
     *
     * @return The maximum value.
     */
    public T max() {
	// your code here
    	DoubleNode<T> current = this.front;
        T minData = this.front.getValue();
        while(current !=  null) {
	            if(current.getValue().compareTo(minData) > 0) {
	            	minData = current.getValue();
	            }
	            current = current.getNext();     
        }
        return minData;
    }

    /**
     * Finds the minimum value in this List.
     *
     * @return The minimum value.
     */
    public T min() {
	// your code here
    	DoubleNode<T> current = this.front;
        T minData = this.front.getValue();
        while(current != null) {
	            if(current.getValue().compareTo(minData) < 0) {
	            	minData = current.getValue();
	            }
	            current = current.getNext();     
        }
        return minData;
    }

    /**
     * Adds a value to the front of this List.
     *
     * @param value
     *            The value to prepend.
     */
    public void prepend(final T value) {
	// your code here
      	if (this.getLength() == 0) {
    		this.front = new DoubleNode<T>(value, null, null);
    		this.rear = this.front;
    	} else {
    		DoubleNode<T> temp = this.front;
    		this.front =  new DoubleNode<T>(value, null, this.front);
    		temp.setPrev(this.front);
    
    	}
      	this.length += 1;
    }

    /**
     * Finds, removes, and returns the value in this List that matches key.
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
     * Removes the value at the front of this List.
     *
     * @return The value at the front of this List.
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
     * Finds and removes all values in this List that match key.
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
     * Reverses the order of the values in this List.
     */
    public void reverse() {
	// your code here
    	DoubleNode<T> newFront = null;
    	DoubleNode<T> temp = null;
    	if(this.front != null) {
    		//Set up rear
    		this.rear = this.front;
    		this.front = this.front.getNext(); //move to 'middle nodes'
    		this.rear.setNext(null); //redundant?
    		newFront = this.rear;
    	}
    	while(this.front != null) {
    		//reverse the middle nodes
    		temp = this.front.getNext(); // maintain original front
    		this.front.setNext(newFront); //middle node ->  rear
    		newFront = this.front; // rear = front
    		this.front = temp; //revert back to original front so that we can loop through the next elment
    		
    	}
    	this.front = newFront;
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
    public void split(final DoubleList<T> target1,
	    final DoubleList<T> target2) {
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
    public void splitAlternate(final DoubleList<T> target1,
	    final DoubleList<T> target2) {
    	// your code here
    	while(!this.isEmpty()) {
    		target1.moveFrontToRear(this);
    		if(!this.isEmpty()) {
    			target2.moveFrontToRear(this);
    		}
    	}
    }

    /**
     * Creates a union of two other Lists into this List. Copies value to this
     * list. source Lists are unchanged.
     *
     * @param source1
     *            The first List to create a union from.
     * @param source2
     *            The second List to create a union from.
     */
    public void union(final DoubleList<T> source1,
            final DoubleList<T> source2) {
            DoubleNode<T> s1Node = source1.front;
            while (s1Node != null) {
                T val = s1Node.getValue();
                if (this.find(val) == null) {
                    this.append(val);
                }
                s1Node = s1Node.getNext();
            }
            
            DoubleNode<T> s2Node = source2.front;
            while (s2Node != null) {
                T val = s2Node.getValue();
                if (this.find(val) == null) {
                    this.append(val);
                }
                s2Node = s2Node.getNext();
            }
            return;
        }
    
    private void moveFrontToRear(DoubleList<T> source) {
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

