package Container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void AddAndGet() {
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
}