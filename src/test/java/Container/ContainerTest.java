package Container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {


    @Test
    void AddGetRemove() {
        Container container=new Container();
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
        container.add(9);
        assertEquals(5, container.getSize());
        container.remove(2);
        assertEquals(8,container.get(2));
        assertEquals(5,container.get(0));
        container.add(11);
        container.add(11);
        container.add(11);
        container.add(11);
        container.add(11);
        assertEquals(10, container.getSize());

    }
}