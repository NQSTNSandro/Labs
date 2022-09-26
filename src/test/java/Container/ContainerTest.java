package Container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {


    @Test
    void isOperator() {
        assertTrue(Container.isOperator('+'));
    }

    @Test
    void priority() {
        assertEquals(1, Container.priority('+'));
    }

    @Test
    void eval() {
        assertEquals(6, Container.eval("2+2*2"));
    }
}