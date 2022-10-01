package com.example.demo;

import Container.Container;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LabsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LabsApplication.class, args);
        Container container=new Container();
        System.out.println(container.eval("5+2-(6+4*10))"));
    }
}
