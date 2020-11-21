package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList storage;

    public Stack(){
        storage = new ImmutableLinkedList();
    }

    public Object peek() {
        return storage.getFirst();
    }

    public void push(Object e) {
        storage = storage.addFirst(e);

    }

    public Object pop() {
        return storage.removeFirst();
    }

    
}
