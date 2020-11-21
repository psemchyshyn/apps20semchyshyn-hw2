import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Main {
    public static void main(String[] args) {
        ImmutableList linkedListList = new ImmutableLinkedList();
        linkedListList = linkedListList.add(5);
        linkedListList = linkedListList.add(23);
        System.out.println(linkedListList);

    }
}
