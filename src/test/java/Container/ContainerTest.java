package Container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {


    @Test
    void isOperator() {
        Container container=new Container();
        assertEquals(true,container.isOperator('+'));
    }


    @Test
    void errors() {
        Container container=new Container();
        assertEquals(false,container.errors("5+2-(6+4*10)/x"));
    }

    @Test
    void eval() {
        Container container=new Container();
        assertEquals(-7,container.eval("5+2-(6+10)/8*(5+2)"));
    }
}