package Container;

import java.util.LinkedList;

public class Container {
    LinkedList<Object> list = new LinkedList<>();

    public void add(Object obj) {
        list.add(obj);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void show() {
        System.out.println(list);
    }

    public Object get(int index) {
        return list.get(index);
    }

}
