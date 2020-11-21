package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class QueueTest {

    private Queue empty;
    private Queue oneEl;
    private Queue multiple;

    @Before
    public void init() {
        Object[] arrEmpty = new Object[] {};
        Object[] arrWithOne = new Object[] {5};
        Object[] arrMany = new Object[] {3, 5, 1, 8, 1, 10};
        empty = new Queue(arrEmpty);
        oneEl = new Queue(arrWithOne);
        multiple = new Queue(arrMany);
    }

    @Test
    public void testEmptyEnqueue() {
        empty.enqueue(5);
        Object[] expected = new Object[] {5};
        assertArrayEquals(expected, empty.toArray());
    }

    @Test
    public void testOneElEnqueue() {
        oneEl.enqueue(7);
        Object[] expected = new Object[] {7, 5};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleEnqueue() {
        multiple.enqueue(8);
        Object[] expected = new Object[] {8, 3, 5, 1, 8, 1, 10};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyDequeue() {
        empty.dequeue();
    }

    @Test
    public void testOneElDequeue() {
        oneEl.dequeue();
        Object[] expected = new Object[] {};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleDequeue() {
        multiple.dequeue();
        Object[] expected = new Object[] {3, 5, 1, 8, 1};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyPeek() {
        empty.peek();
    }

    @Test
    public void testOneElPeek() {
        int expected = 5;
        assertEquals(expected, oneEl.peek());
    }

    @Test
    public void testMultiplePeek() {
        int expected = 10;
        assertEquals(expected, multiple.peek());
    }
}
