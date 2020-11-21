package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    private static class Node {
        public Node next;
        public Object value;
        public Node(Object value) {
            this.next = null;
            this.value = value;
        }

    }
    private int currSize;
    private Node head;

    public ImmutableLinkedList(){
        head = null;
    }

    private ImmutableLinkedList(Node head, int size) {
        this.head = head;
        currSize = size;
    }

    private ImmutableLinkedList internalCopy(){
        if (head != null) {
            Node headCopy = new Node(head.value);
            Node temp = head.next;
            while (temp != null) {
                headCopy.next = new Node(temp.value);
                temp = temp.next;
            }
            return new ImmutableLinkedList(headCopy, currSize);
        }
        return new ImmutableLinkedList();
    }

    private void checkOutOfBounds(int index) {
        if (index < 0 || index >= currSize) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public Node getPrevNode(int index) {
        checkOutOfBounds(--index);
        Node temp = head;
        while (index-- != 0){
            temp = temp.next;
        }
        return temp;
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList copy = internalCopy();
        copy.head = copy.head.next;
        return copy;
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(currSize);
    }


    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(currSize);
    }

    public ImmutableLinkedList addFirst(Object e) {
        ImmutableLinkedList copy = new ImmutableLinkedList();
        Node newNode = new Node(e);
        newNode.next = copy.head;
        copy.head = newNode;
        return copy;
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public ImmutableList add(Object e) {
        return add(currSize, e);
    }

    public ImmutableList add(int index, Object e) {
        ImmutableLinkedList copy = internalCopy();
        Node temp  = copy.getPrevNode(index);
        Node newNode = new Node(e);
        newNode.next = temp.next;
        temp.next = newNode;
        currSize++;
        return copy;
    }

    public ImmutableList addAll(Object[] c) {
        return addAll(currSize, c);
    }

    public ImmutableList addAll(int index, Object[] c) {
        ImmutableList copy = internalCopy();
        for (int i = 0; i < currSize; i++) {
            copy = copy.add(index + i, c);
        }
        return copy;
    }

    public Object get(int index) {
        checkOutOfBounds(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public ImmutableList remove(int index) {
        checkOutOfBounds(index);
        ImmutableLinkedList copy = new ImmutableLinkedList();
        if (index == 0) {
            return removeFirst();
        } else {
            Node temp = copy.getPrevNode(index);
            temp.next = temp.next.next;
        }
        currSize--;
        return copy;
    }

    public ImmutableList set(int index, Object e) {
        checkOutOfBounds(index);
        ImmutableLinkedList copy = internalCopy();
        if (index == 0) {
            copy.head.value = e;
        } else {
            Node temp = getPrevNode(index);
            temp.next.value = e;
        }
        return copy;
    }

    public int indexOf(Object e) {
        int ind = 0;
        for (int i = 0; get(i) != e; i++) {
            ind = i;
            if (ind > currSize) {
                return -1;
            }
        }
        return ind;
    }

    public int size() {
        return currSize;
    }

    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object[] toArray() {
        Object[] arr =  new Object[currSize];
        for (int i = 0; i < currSize; i++){
            arr[i] = get(i);
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer("[ ");
        for (int i = 0; i < currSize; i++) {
            bf.append(get(i));
            bf.append(", ");
        }
        bf = bf.delete(bf.length() - 2, bf.length());
        bf.append(" ]");
        return bf.toString();
    }
}
