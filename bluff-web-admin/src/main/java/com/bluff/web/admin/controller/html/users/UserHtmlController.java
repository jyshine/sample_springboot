package com.bluff.web.admin.controller.html.users;

import com.bluff.domain.dto.user.User;
import com.bluff.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserHtmlController {

    private final UserService userService;

    @Autowired
    public UserHtmlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/new")
    public String newUserForm() {
        return "modules/user/new";
    }

    @PostMapping("/user/new")
    public String newUser(UserForm userForm) {
        User user =new User();
        user.setName(userForm.getName());
        userService.create(user);

        return "redirect:/home";
    }

    @GetMapping("/users")
    public String userList(Model modle){
        List<User> users = userService.findAll();
        modle.addAttribute("users",users);
        return "modules/user/show";
    }

}
