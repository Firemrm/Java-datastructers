/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import ADTs.WorkAheadQueueADT;
import DataStructures.LinearNode;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import java.util.ArrayList;
/**
 *
 * @author mattm
 */
public class WorkAheadQueue<T> implements WorkAheadQueueADT<T>  {
    LinearNode<T> front;
    LinearNode<T> back;
    ArrayList<LinearNode<T>> nodesFrontThree;
    ArrayList<T> elementsFrontThree;
    int numNodes;
    
    public WorkAheadQueue() {
        front = back = null;
        numNodes= 0;
        nodesFrontThree = new ArrayList<LinearNode<T>>();
        elementsFrontThree= new ArrayList<T>();
    }

    @Override
    public T dequeue(int x) throws EmptyCollectionException, InvalidArgumentException {
        
        if (numNodes==0){
            throw new EmptyCollectionException();
        } 
        else if (x < 0|| x > 2 || x > numNodes-1 ){
        throw new InvalidArgumentException("x is invalad");
        }
        else{
            T result = elementsFrontThree.get(x);
        
            if (x==0){
                if (numNodes == 1){
                    front = back = null;
                    nodesFrontThree.remove(0);
                    elementsFrontThree.remove(0);
                } else{
                    front = front.getNext();
                    nodesFrontThree.remove(0);
                    elementsFrontThree.remove(0);
                }
                   
                            
            }
            else if (x ==1) {
                if (numNodes >= 3){
                    front.setNext(nodesFrontThree.get(2));
                }else{
                    front.setNext(null);
                    back=front;
                }
                
                    nodesFrontThree.remove(1);
                    elementsFrontThree.remove(1);                
            }
            else {
                nodesFrontThree.get(1).setNext(nodesFrontThree.get(2).getNext());
                nodesFrontThree.remove(2);
                elementsFrontThree.remove(2);
            }
            
            if (numNodes > 3){
                nodesFrontThree.add(
                        nodesFrontThree.get(
                                nodesFrontThree.size()-1
                        ).getNext());
                elementsFrontThree.add(
                            nodesFrontThree.get(
                                nodesFrontThree.size()-1).getElement());
                }
            numNodes --;
            return result;
        }
    }
       

    @Override
    public T first(int x) throws EmptyCollectionException, InvalidArgumentException {
 
        if (numNodes==0){
            throw new EmptyCollectionException();
        } 
        else if (x < 0|| x > 2 || x > numNodes-1 ){
        throw new InvalidArgumentException("x is invalad");
        }
        return elementsFrontThree.get(x);
    }

    @Override
    public ArrayList<LinearNode<T>> firstThreeNodes() throws EmptyCollectionException {
        return nodesFrontThree;
    }

    @Override
    public ArrayList<T> firstThreeElements() throws EmptyCollectionException {
        /**
 * Returns an ArrayList of the first three elements in the queue.
 * @return ArrayList<T> array list of elements
 * @throws EmptyCollectionException if the queue is empty
 */
	if (isEmpty()) {
		throw new EmptyCollectionException("firstThreeElements(): empty "
				+ "queue");
	}

	elementsFrontThree.clear();
	LinearNode<T> curr = front;

	for (int i = 0; i < 3 && i < size(); i++) {
		elementsFrontThree.add(i, curr.getElement());
		curr = curr.getNext();
	}
	
	return elementsFrontThree;
}
    

    @Override
    public void enqueue(T element) {
        if (numNodes== 0) {
            front= new LinearNode<>(element);
            back= front;
            
            nodesFrontThree.add(front);
            elementsFrontThree.add(element);
        }
        else if (numNodes <= 2){
            LinearNode<T> temp = new LinearNode<>(element);
            back.setNext(temp);
            back= temp;
            nodesFrontThree.add(temp);
            elementsFrontThree.add(element);
        }
        else{
            LinearNode<T> temp = new LinearNode<>(element);
            back.setNext(temp);
            back= temp;
        }
        numNodes=numNodes+1;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
       try{
            return dequeue(0);
        } catch (InvalidArgumentException e){
            return null; // this should never happen.
        }
    }

    @Override
    public T first() throws EmptyCollectionException {
        try{
            return first(0);
        } catch (InvalidArgumentException e){
            return null; // this should never happen.
        }
    }

/**
 * Returns true if the collection contains no elements
 *
 * @return true if the collection is empty
 */
@Override
public boolean isEmpty() {
	return numNodes == 0;
}

 /**
 * Returns the number of elements in the collection
 *
 * @return the number of elements as an int
 */
@Override
public int size() {
	return numNodes;
}
/**
 * Returns a string representation of the collection
 *
 * @return a string representation of the collection
 */
@Override
public String toString() {
	StringBuilder sb = new StringBuilder("");
	LinearNode<T> curr = front;
	for (int i = 0; i < size(); i++) {
		sb.append(curr.getElement().toString());
		if (i < size() - 1) {
			sb.append(", ");
		}
		curr = curr.getNext();
	}
	return sb.toString();
}
}
