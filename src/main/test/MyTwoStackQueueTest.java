package src.main.test;

import main.java.MyTwoStackQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyTwoStackQueueTest {

    private MyTwoStackQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyTwoStackQueue<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.offer(1);
        assertEquals(1, queue.size());
        queue.offer(2);
        assertEquals(2, queue.size());
        queue.poll();
        assertEquals(1, queue.size());
    }

    @Test
    public void testOfferAndPoll() {
        assertTrue(queue.offer(1));
        assertTrue(queue.offer(2));
        assertEquals(Integer.valueOf(1), queue.poll());
        assertEquals(Integer.valueOf(2), queue.poll());
    }

    @Test
    public void testPeek() {
        assertNull(queue.peek());
        queue.offer(1);
        queue.offer(2);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.poll();
        assertEquals(Integer.valueOf(2), queue.peek());
    }

    @Test
    public void testIterator() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        StringBuilder result = new StringBuilder();
        for (Integer item : queue) {
            result.append(item);
        }
        assertEquals("321", result.toString());
    }
}

