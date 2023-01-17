/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import DataStructures.*;
import Exceptions.*;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xiaotuwang
 */
public class WorkAheadQueueTest {
    
    private WorkAheadQueue<Integer> instance;
    
    public WorkAheadQueueTest() {
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    
    @Test
    public void testDequeue_int() throws EmptyCollectionException, 
            InvalidArgumentException {
        System.out.println("dequeue_int");
        int x = 0;     
        instance = new WorkAheadQueue<Integer>();
        
        
        // try to dequeue from an empty set
        try{
            Object result = instance.dequeue(x);
            fail("should not reach here, expect exception");
        }catch (EmptyCollectionException e1){
            assertTrue(e1 instanceof EmptyCollectionException);
        }
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        
        assertEquals(3, instance.size());
        
        LinearNode<Integer> tempNode;
        Integer tempInt;
        tempInt = instance.dequeue();
        assertTrue(tempInt.intValue() == 1);
        assertTrue(instance.size() == 2);
        
        tempInt = instance.dequeue(1);
        assertTrue(tempInt.intValue() == 3);
        
        assertTrue(instance.size()==1);
        
    }
    
    
    /**
     * Test of first method, of class WorkAheadQueue.
     */
    
    @Test
    public void testFirst_int() throws Exception {
        System.out.println("first_int");
        
        instance = new WorkAheadQueue<Integer>();
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        
        assertEquals(3, instance.size());
        
        Integer x = instance.first();
        assertEquals(1, x.intValue());
        instance.dequeue();
        x = instance.first();
        assertEquals(2, x.intValue());
        
    }
    
    
    /**
     * Test of firstThreeNodes method, of class WorkAheadQueue.
     */
    
    @Test
    public void testFirstThreeNodes() throws Exception {
        System.out.println("firstThreeNodes");
         
        instance = new WorkAheadQueue<Integer>();
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        instance.enqueue(4);
        instance.enqueue(5);
        instance.enqueue(6);
        
        assertEquals(6, instance.size());
        
        System.out.println("symbol 1");
        
        ArrayList<LinearNode<Integer>> expResult = new ArrayList();
        
        LinearNode<Integer> x = new LinearNode(1);
        expResult.add(x);
        x = new LinearNode(2);
        expResult.add(x);
        x = new LinearNode(3);
        expResult.add(x);
        
        System.out.println("symbol 3");
        
        ArrayList<LinearNode<Integer>> result = instance.firstThreeNodes();
        System.out.println("symbol 4");
        
        //assertEquals(expResult, result);
        for(int i =0; i<3; i++){
            assertEquals(result.get(i).getElement(), expResult.get(i).getElement());
        }
        
        expResult.clear();
        x = new LinearNode(4);
        expResult.add(x);
        x = new LinearNode(5);
        expResult.add(x);
        x = new LinearNode(6);
        expResult.add(x);
        
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        
        result = instance.firstThreeNodes();
        for(int i =0; i<3; i++){
            assertEquals(result.get(i).getElement(), expResult.get(i).getElement());
        }
        
    }
    
    
    /**
     * Test of firstThreeElements method, of class WorkAheadQueue.
     */
    
    @Test
    public void testFirstThreeElements() throws Exception {
        System.out.println("firstThreeElements");
         
        instance = new WorkAheadQueue<Integer>();
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        instance.enqueue(4);
        instance.enqueue(5);
        instance.enqueue(6);
        
        assertEquals(6, instance.size());
        
        //System.out.println("symbol 1");
        
        ArrayList<Integer> expResult = new ArrayList();
        
        Integer x1 = 1;
        expResult.add(x1);
        
        Integer x2 = 2;
        expResult.add(x2);
        Integer x3 = 3;
        expResult.add(x3);
        
        System.out.println("symbol 3");
        
        ArrayList<Integer> result = instance.firstThreeElements();
        System.out.println("symbol 4");
        
        //assertEquals(expResult, result);
        for(int i =0; i<3; i++){
            assertEquals(result.get(i).intValue(), expResult.get(i).intValue());
        }
        
        expResult.clear();
        Integer x4 = 4;
        expResult.add(x4);
        Integer x5 = 5;
        expResult.add(x5);
        Integer x6 = 6;
        expResult.add(x6);
        
        instance.dequeue();
        instance.dequeue();
        instance.dequeue();
        
        result = instance.firstThreeElements();
        for(int i =0; i<3; i++){
            assertEquals(result.get(i).intValue(), expResult.get(i).intValue());
        }
        
    }
    
    
    /**
     * Test of enqueue method, of class WorkAheadQueue.
     */
    
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
         
        instance = new WorkAheadQueue<Integer>();
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        instance.enqueue(4);
        instance.enqueue(5);
        instance.enqueue(6);
        
        Integer x; 
        assertEquals(6, instance.size());
        
        for(int i = 0; (i<instance.size()-1) &&  (i < 3) ; i++){
            try{
                x = instance.first(i);
                assertEquals((i+1), x.intValue());
            }catch(EmptyCollectionException e1){
                fail("need to quit");
            }
            catch(InvalidArgumentException e2){
                fail("need to quit");
            }
            
        }
    }
    
    
    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    
    @Test
    public void testDequeue_0args() throws Exception {
        System.out.println("dequeue");
         
        instance = new WorkAheadQueue<Integer>();
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        
        assertEquals(3, instance.size());
        
        Integer x = instance.first();
        assertEquals(1, x.intValue());
        int y = instance.size();
        for(int i = 0; i<y; i++){    
            x = instance.dequeue();
            assertEquals(i+1, x.intValue());
        }
    }
    
    
    /**
     * Test of first method, of class WorkAheadQueue.
     */
    
    @Test
    public void testFirst_0args() throws Exception {
        System.out.println("first");
        
        instance = new WorkAheadQueue<Integer>();
        
        assertTrue(instance.isEmpty());
        
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        
        assertEquals(3, instance.size());
        
        Integer x = instance.first();
        assertEquals(1, x.intValue());
        int y = instance.size();
        for(int i = 0; i<y; i++){    
            x = instance.first();
            instance.dequeue();
            assertEquals(i+1, x.intValue());
        }
    }
    
    
    /**
     * Test of isEmpty method, of class WorkAheadQueue.
     */
    /*
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        WorkAheadQueue instance = new WorkAheadQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of size method, of class WorkAheadQueue.
     */
    /*
    @Test
    public void testSize() {
        System.out.println("size");
        WorkAheadQueue instance = new WorkAheadQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    //000000000000000000000000000000000000000
    /**
     * Test of dequeue method for EmptyCollectionException, of class 
     * WorkAheadQueue.
     */
    
    @Test
    public void testDequeue_int_ECE() {
	// Empty collection exception is thrown when collection is empty
        //WorkAheadQueue<Integer> instance;
        
	try {
		instance = new WorkAheadQueue<Integer>();
		instance.dequeue(0);
		fail("Expected ECE did not occur - dequeue(x)");
	}
	catch (EmptyCollectionException e) {
		assertTrue(e instanceof EmptyCollectionException);
	}
        catch (InvalidArgumentException e2) {
                assertTrue(e2 instanceof InvalidArgumentException);            
        }
    }
    
    
/**
 * Test of dequeue method for InvalidArgumentException, of class 
 * WorkAheadQueue.
 */
    
    @Test
    public void testDequeue_int_IAE() {
	// Invalid argument exception is thrown when argument exceeds the size 
	// of the ArrayList or the Queue 
    
        //WorkAheadQueue<Integer> instance;
        
	for (int i = 3; i > 1; i--) {
		instance = new WorkAheadQueue<Integer>();
		for (int j = 0; j < i; j++) {
			instance.enqueue(1);
		}
		try {
			instance.dequeue(i);
			fail("Expected IAE did not occur - dequeue(x)");
		}
		catch (EmptyCollectionException e) {
		    assertTrue(e instanceof EmptyCollectionException);
	        }
                catch (InvalidArgumentException e2) {
                    assertTrue(e2 instanceof InvalidArgumentException);            
                }
	}
    }
    

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    
    @Test
    public void testDequeue_int2() {
         
        instance = new WorkAheadQueue<Integer>();
	
	for (int i = 0; i < 4; i++) {
                
		instance.enqueue(i);
	}
	
	int size = 4;
	assertEquals("After enqueueing N elements, the size of the queue "
			+ "should be N. ", size, instance.size());
	
	for (int i = 2; i >= 0; i--) {
		try {
			instance.dequeue(i);
			assertEquals("Dequeueing elements should decrease the size of "
					+ "the queue.", --size, instance.size());
		}
		catch (EmptyCollectionException e) {
		    assertTrue(e instanceof EmptyCollectionException);
	        }
                catch (InvalidArgumentException e2) {
                    assertTrue(e2 instanceof InvalidArgumentException);            
                }
	}

	// Elements that are dequeued from the front are no longer at the front
	// The method returns the element that was removed
	instance = new WorkAheadQueue<Integer>();
	instance.enqueue(1);
	instance.enqueue(2);
	try {
		assertEquals("The first element enqueued should be returned by the "
				+ "first method.", new Integer(1), instance.first());
	}
	catch (EmptyCollectionException e) {
		fail("Unexpected " + e.getClass().getSimpleName() 
				+ " occurred - first()");
	}
        
	try {
		assertEquals("Dequeueing the element from the front should return "
				+ "it.", new Integer(1), instance.dequeue(0));
	}
	catch (EmptyCollectionException e) {
            assertTrue(e instanceof EmptyCollectionException);
	}
        catch (InvalidArgumentException e2) {
            assertTrue(e2 instanceof InvalidArgumentException);            
        }
        
	try {
            assertEquals("An element should no longer be at the front once it "
		+ "has been dequeued.", new Integer(2), instance.first());
	}
	catch (EmptyCollectionException e) {
		fail("Unexpected " + e.getClass().getSimpleName() 
				+ " occurred - first()");
	}
    }
    
}
