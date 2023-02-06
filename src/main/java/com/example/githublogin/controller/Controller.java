package com.example.githublogin.controller;

import com.example.githublogin.controller.dto.UserDto;
import com.example.githublogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
@RestController
public class Controller {
    @Autowired
    UserService service;
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        String name = principal.getAttribute ("name");
        String email = principal.getAttribute ("email");
        String socialId =  principal.getAttribute ("id").toString ();
        service.addUser (new UserDto (socialId,name,email));
        return Collections.singletonMap ("name", principal.getAttribute("name"));
    }
}
