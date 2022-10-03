package servises;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes={HumanServise.class})
@ComponentScan(basePackages = {"servises"})
class HumanServiseTest {
    @Autowired
    private HumanServise servise;

   @Test
    void func() {

       System.out.println("0");

    }




}