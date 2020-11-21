package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList empty;
    private ImmutableArrayList oneEl;
    private ImmutableArrayList multiple;

    @Before
    public void init() {
        Object[] arrEmpty = {};
        Object[] arrWithOne = {5};
        Object[] arrMany = {3, 5, 1, 8, 1, 10};
        empty = new ImmutableArrayList(arrEmpty);
        oneEl = new ImmutableArrayList(arrWithOne);
        multiple = new ImmutableArrayList(arrMany);
    }

    @Test
    public void testInit() {
        System.out.println();
    }
    
}
