package net.vkolev.springjsonbexample;

import org.springframework.boot.SpringApplication;

public class TestSpringJsonbExampleApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringJsonbExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
