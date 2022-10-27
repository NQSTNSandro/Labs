package Container;
import java.util.Arrays;
/**
 * @author Sergey Bochkov
 * @version lab 1
 */
public class Container {
    private Object[] list=new Object[5];
    private Integer index=0;
    private Integer size=10;
    public Container(){}

    /**
     *
     * @param value элемент который необходимо добавить в контейнер
     *
     */
    public void add(Object value){
        if(list[list.length-1]==null) {
            list[index] = value;
            index++;
        }
        else {
            Object[] oldList=list;
            list = new Object[size];
            size+=5;
            System.arraycopy(oldList, 0, list, 0, oldList.length);
            list[index]=value;
            index++;
        }
    }

    /**
     *
     * @param i индекс удаляемого элемента
     *
     *  */
    public void remove(int i){
        if(i<= list.length-1) {
            for (int j = i; j < list.length - 1; j++) {
                list[j] = list[j + 1];
            }
            list[list.length - 1] = null;
            index--;
        }
        else throw new IndexOutOfBoundsException();
    }
    public Integer getSize(){return list.length;}


    /**
     *
     * @param i индекс получаемого элемента
     * @return элемент который хотим получить
     */
    public Object get(int i){
        return list[i];
    }
    public void show(){
        System.out.println(Arrays.toString(list));
    }

}
