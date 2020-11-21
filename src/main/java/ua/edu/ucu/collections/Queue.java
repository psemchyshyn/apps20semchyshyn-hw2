package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    // The last element of the Queue is the first element of the storage
    private ImmutableLinkedList storage;

    public Queue() {
        storage = new ImmutableLinkedList();
    }

    public Queue(Object[] from) {
        storage = new ImmutableLinkedList(from);
    }

    public Object peek() {
        return storage.getLast();
    }

    public void enqueue(Object e) {
        storage = storage.addFirst(e);
    }

    public Object dequeue() {
        Object toRemove = peek();
        storage = storage.removeLast();
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
