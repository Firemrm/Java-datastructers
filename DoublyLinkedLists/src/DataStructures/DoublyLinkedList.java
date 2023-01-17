/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;
import Exceptions.*;
import ADTs.*;
/**
 *
 * @author clatulip
 * edited by mattm 
 */
public class DoublyLinkedList<T extends Comparable> implements ListADT<T> {

    protected LinearNode<T> first;
    protected LinearNode<T> last;
    protected int numNodes;

    public DoublyLinkedList() {
        first = null;
        last = null;
        numNodes = 0;
    }

    @Override
    public void addFirst(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setNext(first);
        first.setPrev(temp);
        first = temp;
        numNodes++;
    }

    @Override
    public void addLast(T element) {
        LinearNode<T> temp = new LinearNode<>(element);
        if (numNodes == 0) {
            first = temp;
            last = temp;
            numNodes++;
            return;
        }
        temp.setPrev(last);
        last.setNext(temp);
        last = temp;
        numNodes++;
    }

    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException {
        LinearNode<T> temp = new LinearNode<>(element);
        LinearNode<T> curr = first;
        while (curr != null) {
            if (curr.getElement().compareTo(existing) == 0) {
                // found existing element, add temp after this
                temp.setNext(curr.getNext());
                temp.setPrev(curr);
                if (curr.getNext() != null) {
                    curr.getNext().setPrev(temp);
                } else {
                    // adding at the end
                    last = temp;
                }
                curr.setNext(temp);
                numNodes++;
                return;
            } else {
                curr = curr.getNext();
            }
        }
        // iterated through and didn't find existing element
        throw new ElementNotFoundException("DoubleLinkedList: addAfter(..) method");
    
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T result = null;
        LinearNode<T> curr = first;
        while (curr != null) {
            if (curr.getElement().compareTo(element) == 0) {
                // found the element, so remove this node
                result = curr.getElement();
                // check special case of removing only element
                if ((curr == first) && (curr == last)) {
                    first = null;
                    last = null;
                    numNodes--;
                    return result;
                }
                // check special case of removing first element
                if (curr == first) {
                    first = curr.getNext();
                    first.setPrev(null);
                    numNodes--;
                    return result;
                }
                // check special case of removing last element
                if (curr == last) {
                    last = curr.getPrev();
                    last.setNext(null);
                    numNodes--;
                    return result;
                }
                // normal case, removing in middle
                curr.getPrev().setNext(curr.getNext());
                curr.getNext().setPrev(curr.getPrev());
                numNodes--;
                return result;
            } // end if
            curr = curr.getNext();
        } // end iteration through list
        throw new ElementNotFoundException("DoubleLinkedList, remove(element) method");
        
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T result = null;
        LinearNode<T> curr = first;
        

        result = curr.getElement();
        // check special case of removing only element
        if ((curr == first) && (curr == last)) {
            first = null;
            last = null;
            numNodes--;
            return result;
        } 
        first = curr.getNext();
        first.setPrev(null);
        numNodes--;
        return result;
           
    }
    

    @Override
    public T removeLast() throws EmptyCollectionException {

if (numNodes == 0)
    throw new EmptyCollectionException("DoubleLinkedList");
T result = null;
LinearNode<T> curr = last;  
result = curr.getElement();
    
if ((curr == first) && (curr == last)) {
    first = null;
    last = null;
    numNodes--;
    return result; 
}
    
last = curr.getPrev();
last.setNext(null);
numNodes--;
return result;
}



    @Override
    public T first() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T element = first.getElement();
        return element;
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (numNodes == 0)
            throw new EmptyCollectionException("DoubleLinkedList");
        T element = last.getElement();
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (numNodes == 0);
    }

    @Override
    public int size() {
        return numNodes;
    }




    
    
    
    
}
