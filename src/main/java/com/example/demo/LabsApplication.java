package com.example.demo;

import Container.Container;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
		Container container=new Container();
		container.add(5);
		container.add(8);
		container.add(16);
		container.add(4);
		container.add(20);
		container.show();
		container.remove(2);
		container.show();
		System.out.println(container.get(1));
	}


}
