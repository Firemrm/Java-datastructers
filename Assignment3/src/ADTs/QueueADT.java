package ADTs;
import Exceptions.EmptyCollectionException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * An interface for a Stack
 * Specific stack implementations will implement this interface
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public interface QueueADT<T> extends CollectionADT<T> {
    
    /**
     * Adds the specified element to the end of the queue
     * @param element element to be added to the end of the queue
     */
    public void enqueue(T element);
    
    /**
     * Removes and returns the element that is at the front of the queue
     * @return the element removed from the queue
     * @throws EmptyCollectionException 
     */
    public T dequeue() throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the element that is at the front of the queue
     * @return the element at the front of the queue
     * @throws EmptyCollectionException 
     */
    public T first()throws EmptyCollectionException;
    
}