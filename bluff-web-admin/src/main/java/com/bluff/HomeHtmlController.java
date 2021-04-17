package com.bluff;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeHtmlController {

    @GetMapping("admin")
    public String hello(Model modle){
        modle.addAttribute("data", "배승찬");
        return "hello";
    }

    @GetMapping("home")
    public String home(Model modle){
        return "modules/home/index";
    }
}
