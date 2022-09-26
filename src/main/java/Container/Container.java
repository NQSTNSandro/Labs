package Container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sergey Bochkov
 * @version Lab 3
 */
public class Container {
    LinkedList<Integer> linkedList = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    public void testLinkedList() {
        long start_0 = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            linkedList.add(i);
        }
        System.out.println("Время работы операции add для LinkedList (в милисекундах) = " + (System.currentTimeMillis() - start_0));

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            linkedList.add(1235, Integer.MAX_VALUE);
        }
        System.out.println("Время работы операции add(в середину) для LinkedList (в милисекундах) = " + (System.currentTimeMillis() - start));
        long start_1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        System.out.println("Время работы операции get для LinkedList (в милисекундах) = " + (System.currentTimeMillis() - start_1));
        long start_2 = System.currentTimeMillis();
        for (int i = 5000000; i >= 1; i--) {
            linkedList.remove(i);
        }
        System.out.println("Время работы операции remove для List (в милисекундах) = " + (System.currentTimeMillis() - start_2));
    }

    public void testArrayList() {
        long start_0 = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        System.out.println("Время работы операции add для List (в милисекундах) = " + (System.currentTimeMillis() - start_0));

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list.add(1235, Integer.MAX_VALUE);
        }
        System.out.println("Время работы операции add(в середину) для List (в милисекундах) = " + (System.currentTimeMillis() - start));
        long start_1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
        System.out.println("Время работы операции get для List (в милисекундах) = " + (System.currentTimeMillis() - start_1));
        long start_2 = System.currentTimeMillis();
        for (int i = 5000000; i >= 1; i--) {
            list.remove(i);
        }
        System.out.println("Время работы операции remove для List (в милисекундах) = " + (System.currentTimeMillis() - start_2));
    }
}

