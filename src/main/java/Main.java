import ua.edu.ucu.collections.Stack;
import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Main {
    public static void main(String[] args) {
        Object[] arr = new Object[] {1, 4, 5, 2, 8};
        Stack stack1 = new Stack(arr);
        System.out.println(stack1);
        stack1.pop();
        System.out.println(stack1);
        stack1.push(259);
        System.out.println(stack1);

    }
}
