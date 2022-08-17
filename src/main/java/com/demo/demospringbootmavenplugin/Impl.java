package com.demo.demospringbootmavenplugin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class Impl {

    @Value("${env}")
    private String env;

    public void print() {
        System.out.println("Method executed from env: " + env);
        try {
            Files.list(Path.of("results"))
                    .forEach(f -> System.out.println(f.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
