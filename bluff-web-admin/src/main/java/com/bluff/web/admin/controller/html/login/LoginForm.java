package com.bluff.web.admin.controller.html.login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginForm {

    @NotEmpty
    String loginId;

    @NotEmpty
    String password;

    //로그인한 채로 둘 것인지 여부
    boolean rememberMe;

}
