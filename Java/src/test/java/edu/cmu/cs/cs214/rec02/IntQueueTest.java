package edu.cmu.cs.cs214.rec02;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    @Before
    public void setUp() {
        // ArrayIntQueue болон LinkedIntQueue аль аль дээр тест хийх боломжтой
        mQueue = new ArrayIntQueue();  // Энд LinkedIntQueue-г орлуулж үзэж болно
        testList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        mQueue.enqueue(1);
        assertFalse(mQueue.isEmpty());
    }

    @Test
    public void testPeekEmptyQueue() {
        mQueue.clear();
        assertNull(mQueue.peek());
    }

    @Test
    public void testPeekNoEmptyQueue() {
        mQueue.enqueue(1);
        assertEquals(Integer.valueOf(1), mQueue.peek());
    }

    @Test
    public void testEnqueue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), mQueue.peek());
            assertEquals(i + 1, mQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        // Enqueue some items
        for (Integer value : testList) {
            mQueue.enqueue(value);
        }

        // Dequeue and check values
        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testList.get(i), mQueue.dequeue());
        }

        // Ensure the queue is empty after all dequeues
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testDequeueFromEmptyQueue() {
        // Try dequeuing from an empty queue
        assertNull(mQueue.dequeue());
    }

    @Test
    public void testSize() {
        assertEquals(0, mQueue.size());

        // Enqueue elements and check size
        mQueue.enqueue(1);
        assertEquals(1, mQueue.size());

        mQueue.enqueue(2);
        assertEquals(2, mQueue.size());

        // Dequeue one and check size again
        mQueue.dequeue();
        assertEquals(1, mQueue.size());
    }

    @Test
    public void testClear() {
        // Enqueue some items and clear the queue
        for (Integer value : testList) {
            mQueue.enqueue(value);
        }
        mQueue.clear();
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testContent() {
        // This test will enqueue elements and check them via dequeue
        for (Integer value : testList) {
            mQueue.enqueue(value);
        }

        for (int i = 0; i < testList.size(); i++) {
            assertEquals(testList.get(i), mQueue.dequeue());
        }

        // Ensure queue is empty at the end
        assertTrue(mQueue.isEmpty());
    }
}
