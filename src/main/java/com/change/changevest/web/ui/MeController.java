package com.change.changevest.web.ui;

import com.change.changevest.web.domain.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @RequestMapping(value = "/me", method = RequestMethod.GET, produces = "application/json")
    public User getUser(@AuthenticationPrincipal User user) {
        return user;
    }
}
