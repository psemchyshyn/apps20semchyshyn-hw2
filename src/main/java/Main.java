import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Main {
    public static void main(String[] args) {
        Object[] arr = new Object[] {4, 2, 4, 5};
        ImmutableList arrayList = new ImmutableArrayList(arr);
        System.out.println(arrayList);
        arr[1] = 5;
        System.out.println(arrayList);
    }
}
