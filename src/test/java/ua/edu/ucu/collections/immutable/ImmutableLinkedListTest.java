package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.rmi.UnexpectedException;
import java.util.Objects;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private ImmutableList empty;
    private ImmutableList oneEl;
    private ImmutableList multiple;

    @Before
    public void init() {
        Object[] arrEmpty = new Object[] {};
        Object[] arrWithOne = new Object[] {5};
        Object[] arrMany = new Object[] {3, 5, 1, 8, 1, 10};
        empty = new ImmutableLinkedList(arrEmpty);
        oneEl = new ImmutableLinkedList(arrWithOne);
        multiple = new ImmutableLinkedList(arrMany);
    }

    @Test
    public void testEmptyToArr() {
        Object[] expected = new Object[] {};
        assertArrayEquals(expected, empty.toArray());
    }

    @Test
    public void testOneToArr() {
        Object[] expected = new Object[] {5};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleToArr() {
        Object[] expected = new Object[] {3, 5, 1, 8, 1, 10};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test
    public void initEmpty() {
        Object[] expected = {};
        assertArrayEquals(expected, empty.toArray());
    }

    @Test
    public void initOneEl() {
        Object[] expected = {5};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void initMultiple() {
        Object[] expected = {3, 5, 1, 8, 1, 10};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test
    public void testEmptyAdd() {
        empty = empty.add(7);
        Object[] expected = new Object[] {7};
        assertArrayEquals(expected, empty.toArray());
    }

    @Test
    public void testOneElAdd() {
        oneEl = oneEl.add(7);
        Object[] expected = new Object[] {5, 7};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleAdd() {
        multiple = multiple.add(7);
        Object[] expected = new Object[] {3, 5, 1, 8, 1, 10, 7};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyAddIndex() {
        empty = empty.add(5, 23);
    }

    @Test
    public void testOneElAddIndex() {
        oneEl = oneEl.add(0, 100);
        Object[] expected = new Object[] {100, 5};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleAddIndex() {
        multiple = multiple.add(3, 100);
        Object[] expected = new Object[] {3, 5, 1, 100, 8, 1, 10};
        assertArrayEquals(expected, multiple.toArray());
    }


    @Test
    public void testEmptyAddAll() {
        Object[] arr = {1, 1, 1, 1, 1};
        empty = empty.addAll(arr);
        assertArrayEquals(arr, empty.toArray());
    }

    @Test
    public void testOneElAddAll() {
        Object[] arr = {1, 1, 1, 1, 1};
        oneEl = oneEl.addAll(arr);
        Object[] expected = new Object[] {5 ,1, 1, 1, 1, 1};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleAddAll() {
        Object[] arr = {1, 1, 1, 1, 1};
        multiple = multiple.addAll(arr);
        Object[] expected = new Object[] {3, 5, 1, 8, 1, 10, 1, 1, 1, 1, 1};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyAddAllIndex() {
        Object[] arr = {1, 1, 1, 1, 1};
        empty = empty.addAll(5, arr);
    }

    @Test
    public void testOneElAddAllIndex() {
        Object[] arr = {1, 1, 1, 1, 1};
        oneEl = oneEl.addAll(0, arr);
        Object[] expected = new Object[] {1, 1, 1, 1, 1, 5};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleAddAllIndex() {
        Object[] arr = {1, 1, 1, 1, 1};
        multiple = multiple.addAll(1, arr);
        Object[] expected = new Object[] {3, 1, 1, 1, 1, 1, 5, 1, 8, 1, 10};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyRemove() {
        empty = empty.remove(1);
    }

    @Test
    public void testOneElRemove() {
        oneEl = oneEl.remove(0);
        Object[] expected = new Object[] {};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleRemove() {
        multiple = multiple.remove(4);
        Object[] expected = new Object[] {3, 5, 1, 8, 10};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptySet() {
        empty = empty.set(0, 34);
    }

    @Test
    public void testOneElSet() {
        oneEl = oneEl.set(0, 100);
        Object[] expected = new Object[] {100};
        assertArrayEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleSet() {
        multiple = multiple.set(2, 1000);
        Object[] expected = new Object[] {3, 5, 1000, 8, 1, 10};
        assertArrayEquals(expected, multiple.toArray());
    }

    @Test()
    public void testEmptyindexOf() {
        int index = empty.indexOf(25);
        assertEquals(-1, index);
    }

    @Test
    public void testOneElIndexOf() {
        int index = oneEl.indexOf(5);
        int expected = 0;
        assertEquals(expected, index);
    }

    @Test
    public void testMultipleIndexOf() {
        int index = multiple.indexOf(10);
        int exp = 5;
        assertEquals(exp, index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyGet() {
        Object res = empty.get(0);

    }

    @Test
    public void testOneElGet() {
        Object res = oneEl.get(0);
        int expected = 5;
        assertEquals(expected, res);
    }

    @Test
    public void testMultipleGet() {
        Object res = multiple.get(1);
        int exp = 5;
        assertEquals(exp, res);
    }


    @Test
    public void testEmptyClear() {
        empty = empty.clear();
        Object[] expected = new Object[0];
        assertArrayEquals(expected, empty.toArray());
    }

    @Test
    public void testOneElClear() {
        oneEl = oneEl.clear();
        Object[] expected = new Object[0];
        assertEquals(expected, oneEl.toArray());
    }

    @Test
    public void testMultipleClear() {
        multiple = multiple.clear();
        Object[] exp = new Object[0];
        assertEquals(exp, multiple.toArray());
    }

    @Test
    public void testEmptySize() {
        int size = empty.size();
        int expected = 0;
        assertEquals(expected, size);
    }

    @Test
    public void testOneElSize() {
        int size = oneEl.size();
        int expected = 1;
        assertEquals(expected, size);
    }

    @Test
    public void testMultipleSize() {
        int size = multiple.size();
        int expected = 6;
        assertEquals(expected, size);
    }

    @Test
    public void testEmptyEmpty() {
        boolean empt = empty.isEmpty();
        boolean expected = true;
        assertEquals(expected, empt);
    }

    @Test
    public void testOneElEmpty() {
        boolean empt = oneEl.isEmpty();
        boolean expected = false;
        assertEquals(expected, empt);
    }

    @Test
    public void testMultipleEmpty() {
        boolean empt = multiple.isEmpty();
        boolean expected = false;
        assertEquals(expected, empt);
    }

    @Test
    public void testEmptyToString() {
        String expected = "[  ]";
        assertEquals(expected, empty.toString());
    }

    @Test
    public void testOneElToString() {
        String expected = "[ 5 ]";
        assertEquals(expected, oneEl.toString());
    }

    @Test
    public void testMultipleToString() {
        String expected = "[ 3, 5, 1, 8, 1, 10 ]";
        assertEquals(expected, multiple.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyRemoveLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) empty;
        list = list.removeLast();
    }

    @Test
    public void testOneElRemoveLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) oneEl;
        list = list.removeLast();
        Object[] expected = new Object[0];
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testMultipleRemoveLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) multiple;
        list = list.removeLast();
        Object[] expected = new Object[] {3, 5, 1, 8, 1};
        assertArrayEquals(expected, list.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyRemoveFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) empty;
        list = list.removeFirst();
    }

    @Test
    public void testOneElRemoveFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) oneEl;
        list = list.removeFirst();
        Object[] expected = new Object[0];
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testMultipleRemoveFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) multiple;
        list = list.removeFirst();
        Object[] expected = new Object[] {5, 1, 8, 1, 10};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testEmptyaddLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) empty;
        list = list.addLast(5);
        Object[] expected = new Object[] {5};
        assertArrayEquals(expected, list.toArray());

    }

    @Test
    public void testOneEladdLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) oneEl;
        list = list.addLast(5);
        Object[] expected = new Object[] {5, 5};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testMultipleaddLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) multiple;
        list = list.addLast(5);
        Object[] expected = new Object[] {3, 5, 1, 8, 1, 10, 5};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testEmptyaddFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) empty;
        list = list.addFirst(5);
        Object[] expected = new Object[] {5};
        assertArrayEquals(expected, list.toArray());

    }

    @Test
    public void testOneEladdFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) oneEl;
        list = list.addFirst(7);
        Object[] expected = new Object[] {7, 5};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testMultipleaddFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) multiple;
        list = list.addFirst(5);
        Object[] expected = new Object[] {5, 3, 5, 1, 8, 1, 10};
        assertArrayEquals(expected, list.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptygetLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) empty;
        Object res = list.getLast();
    }

    @Test
    public void testOneElgetLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) oneEl;
        int expected  = 5;
        assertEquals(expected, list.getLast());
    }

    @Test
    public void testMultiplegetLast() {
        ImmutableLinkedList list = (ImmutableLinkedList) multiple;
        int expected  = 10;
        assertEquals(expected, list.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptygetFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) empty;
        Object res = list.getFirst();
    }

    @Test
    public void testOneElgetFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) oneEl;
        int expected  = 5;
        assertEquals(expected, list.getFirst());
    }

    @Test
    public void testMultiplegetFirst() {
        ImmutableLinkedList list = (ImmutableLinkedList) multiple;
        int expected  = 3;
        assertEquals(expected, list.getFirst());
    }
}
