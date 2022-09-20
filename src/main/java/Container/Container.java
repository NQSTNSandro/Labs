package Container;

import java.util.LinkedList;

/**
 * @author Sergey Bochkov
 * @version lab 1
 */
public class Container {
    /**
     * Создаю связный список
     */
    private LinkedList<Object> list = new LinkedList<>();


    /**
     * @param obj - лемент добавляемый в список
     */
    public void add(Object obj) {
        list.add(obj);
    }

    /**
     * @param index - Индекс элемента, который необходимо удалить
     */
    public void remove(int index) {
        list.remove(index);
    }

    /**
     * Вывод списка в консоль
     */
    public void show() {
        System.out.println(list);
    }

    /**
     * @param index - Индекс извлекаемого элемента
     * @return - элемент который необходимо извлечь
     */
    public Object get(int index) {
        return list.get(index);
    }

}
