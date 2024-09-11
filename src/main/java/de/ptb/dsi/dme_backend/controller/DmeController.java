package de.ptb.dsi.dme_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/dme-comparison")

public class DmeController {

    @GetMapping("/sayHello")
    public String sayHelloWorld() {return "Hi";
    }
}

