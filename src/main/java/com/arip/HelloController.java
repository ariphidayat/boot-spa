package com.arip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Arip Hidayat on 8/30/2017.
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }
}
