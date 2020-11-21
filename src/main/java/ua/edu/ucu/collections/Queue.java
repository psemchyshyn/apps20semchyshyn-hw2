package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue<Type> {
    private ImmutableLinkedList<Type> storage;

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
