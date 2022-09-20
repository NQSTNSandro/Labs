package Container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void add() {
        Container container = new Container();
        container.add(16);
        assertEquals(16, container.get(0));
    }

    @Test
    void remove() {
        Container container = new Container();
        container.add(5);
        container.add(8);
        container.add(10);
        container.remove(1);
        assertEquals(10, container.get(1));

    }

    @Test
    void show() {

    }

    @Test
    void get() {
        Container container = new Container();
        container.add(5);
        assertEquals(5, container.get(0));
    }
}