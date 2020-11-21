package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    // First element of the storage is the top of the stack
    private ImmutableLinkedList storage;

    public Stack() {
        storage = new ImmutableLinkedList();
    }

    public Stack(Object[] from) {
        this();
        for (int i = 0; i < from.length; i++) {
            push(from[i]);
        }
    }

    public Object peek() {
        return storage.getFirst();
    }

    public void push(Object e) {
        storage = storage.addFirst(e);
    }

    public Object pop() {
        Object toRemove = storage.getFirst();
        storage = storage.removeFirst();
        return toRemove;
    }

    public Object[] toArray() {
        return storage.toArray();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
