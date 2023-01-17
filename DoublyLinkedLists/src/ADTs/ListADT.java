package ADTs;

import Exceptions.*;

/**
 * @author clatulip
 */
public interface ListADT<T> extends CollectionADT {
    
    /**
     * Adds the specified element to the list at the front
     * @param element: the element to be added
     * 
     */
    public void addFirst(T element);
    
    /**
     * Adds the specified element to the end of the list
     * @param element: the element to be added
     */
    public void addLast(T element);
    
    /**
     * Adds the specified element to the list after the existing element
     * @param existing: the element that is in the list already
     * @param element: the element to be added
     * @throws ElementNotFoundException if existing isn't in the list
     */
    public void addAfter(T existing, T element) throws ElementNotFoundException;
    
    /**
     * Removes and returns the specified element 
     * @return the element specified
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;
    
    /**
     * Removes and returns the first element 
     * @return the first element in the list
     * @throws EmptyCollectionException 
     */
    public T removeFirst() throws EmptyCollectionException;
    
    /**
     * Removes and returns the last element 
     * @return the last element in the list
     * @throws EmptyCollectionException 
     */
    public T removeLast()throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the first element in the list
     * @return element at the beginning of the list
     * @throws EmptyCollectionException 
     */
    public T first() throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the last element in the list
     * @return element at the end of the list
     * @throws EmptyCollectionException 
     */
    public T last() throws EmptyCollectionException;
    
    
}
