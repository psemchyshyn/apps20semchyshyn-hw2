package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList storage;

    public Queue(){
        storage = new ImmutableLinkedList();
    }

    public Object peek() {
        return storage.getLast();
    }

    public void enqueue(Object e) {
        storage = storage.addFirst(e);
    }

    public Object dequeue() {
        return storage.removeLast();
    }
}
