package com.change.changevest.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MeController {

    @RequestMapping("/me")
    public Principal user(Principal user) {
        return user;
    }
}