package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StackTest {

        private Stack empty;
        private Stack oneEl;
        private Stack multiple;

        @Before
        public void init() {
            Object[] arrEmpty = new Object[] {};
            Object[] arrWithOne = new Object[] {5};
            Object[] arrMany = new Object[] {3, 5, 1, 8, 1, 10};
            empty = new Stack(arrEmpty);
            oneEl = new Stack(arrWithOne);
            multiple = new Stack(arrMany);
        }

        @Test
        public void testEmptyPush() {
            empty.push(5);
            Object[] expected = new Object[] {5};
            assertArrayEquals(expected, empty.toArray());
        }

        @Test
        public void testOneElPush() {
            oneEl.push(7);
            Object[] expected = new Object[] {7, 5};
            assertArrayEquals(expected, oneEl.toArray());
        }

        @Test
        public void testMultiplePush() {
            multiple.push(8);
            Object[] expected = new Object[] {8, 10, 1, 8, 1, 5, 3};
            assertArrayEquals(expected, multiple.toArray());
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void testEmptyPop() {
            empty.pop();
        }

        @Test
        public void testOneElPop() {
            oneEl.pop();
            Object[] expected = new Object[] {};
            assertArrayEquals(expected, oneEl.toArray());
        }

        @Test
        public void testMultiplePop() {
            multiple.pop();
            Object[] expected = new Object[] {1, 8, 1, 5, 3};
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

