package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private static final int DEFAULT_SIZE = 10;
    private int currSize;
    private Object[] storage;

    public ImmutableArrayList() {
        storage = new Object[DEFAULT_SIZE];
    }

    public ImmutableArrayList(Object[] from) {
        storage = from.length == 0 ? new Object[DEFAULT_SIZE] : from;
        currSize = from.length;
    }

    private ImmutableArrayList(Object[] values, int size) {
        storage = values;
        currSize = size;
    }

    private Object[] expand() {
        return changeBuffer(1);
    }

    private Object[] shrink() {
        return changeBuffer(2);
    }

    private Object[] changeBuffer(int with) {
        Object[] temp;
        if (currSize == storage.length / with) {
            temp = Arrays.copyOf(storage, currSize + currSize / with);
        } else {
            temp = Arrays.copyOf(storage, storage.length);
        }
        return temp;
    }

    private void checkIndexRange(int index) {
        if (index < 0 || index >= currSize) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    public ImmutableList add(Object e) {
        return add(currSize, e);
    }

    public ImmutableList add(int index, Object e) {
        // If index is out of bounds, simply add it to the end
        if (index < 0 || index > currSize) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Object[] values = expand();
        int i = currSize;
        while (i != index) {
            values[i] = values[i - 1];
            i--;
        }
        values[i] = e;
        return new ImmutableArrayList(values, currSize + 1);

    }
    public ImmutableList addAll(Object[] c) {
        return addAll(currSize, c);
    }

    public ImmutableList addAll(int index, Object[] c) {
        ImmutableList temp = new ImmutableArrayList(storage, currSize);
        for (int i = 0; i < c.length; i++) {
            temp = temp.add(index + i, c[i]);
        }
        return temp;
    }

    public Object get(int index) {
        checkIndexRange(index);
        return storage[index];
    }

    public ImmutableList remove(int index) {
        if (index < 0 || index > currSize) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Object[] values = shrink();
        int i = index;
        while (i < currSize - 1) {
            values[i] = values[i + 1];
            i++;
        }
        values[i] = null;
        return new ImmutableArrayList(values, currSize - 1);
    }

    public ImmutableList set(int index, Object e) {
        checkIndexRange(index);
        Object[] values = expand();
        values[index] = e;
        return new ImmutableArrayList(values, currSize);
    }

    public int indexOf(Object e) {
        for (int i = 0; i < currSize; i++) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return currSize;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public Object[] toArray() {
        Object[] arr = new Object[currSize];
        for (int i = 0; i < currSize; i++) {
            arr[i] = get(i);
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer("[ ");
        for (int i = 0; i < currSize; i++) {
            bf.append((Object) get(i));
            bf.append(", ");
        }
        if (bf.length() > 3) {
            bf = bf.delete(bf.length() - 2, bf.length());
        }
        bf.append(" ]");
        return bf.toString();
    }
}
