package org.github.follow.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @GetMapping("/oauth/login")
    private String signIn(@RequestParam String code) {
        return "OK";
    }
}
