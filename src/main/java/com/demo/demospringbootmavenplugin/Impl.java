package com.demo.demospringbootmavenplugin;

import org.springframework.stereotype.Component;

@Component
public class Impl {

    public void print() {
        System.out.println("Method executed");
        System.out.println("----------------------------------------------------------");
    }
}
