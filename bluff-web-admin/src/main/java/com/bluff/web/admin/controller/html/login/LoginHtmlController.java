package com.bluff.web.admin.controller.html.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginHtmlController {

    @GetMapping("login")
    public String index(@ModelAttribute LoginForm form, Model modle){
        return "modules/login/login";
    }

}
