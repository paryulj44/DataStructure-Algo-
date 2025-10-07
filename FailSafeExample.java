/*
 * How It Works Internally:

Fail-Safe iterators:

Work on a clone (snapshot) of the collection.

Modifications are done on the original collection, not the iterator’s copy.

So, the iterator never sees the change.

Hence, no exception, but changes aren’t reflected during iteration.
 */

import java.util.concurrent.*;

public class FailSafeExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for (String s : list) {
            System.out.println(s);
            list.add("D"); // ✅ Allowed — modifies copy
        }

        System.out.println("Final List: " + list);
    }
}

