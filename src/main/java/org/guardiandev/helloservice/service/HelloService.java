package org.guardiandev.helloservice.service;

import org.guardiandev.helloservice.models.Hello;
import org.springframework.stereotype.Service;

@Service
public final class HelloService {

    public Hello getHello() {
        return new Hello().text("Hello World!");
    }
}
