package com.arip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arip Hidayat on 8/30/2017.
 */
@RestController
@RequestMapping("api")
public class HelloRestController {

    @GetMapping("hello")
    public String hello() {
        return "Hello Boot!";
    }
}
