package com.change.changevest.web.ui;

import com.change.changevest.web.application.InvestmentService;
import com.change.changevest.web.domain.model.AccountSettings;
import com.change.changevest.web.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-settings")
public class AccountSettingsController {

    @Autowired
    private InvestmentService investmentService;

    @RequestMapping(method = RequestMethod.PUT)
    public AccountSettings updateAccountSettings(@AuthenticationPrincipal User user, @RequestBody AccountSettings accountSettings) {
        return investmentService.updateAccountSettings(user.getId(), accountSettings);
    }

    @RequestMapping(method = RequestMethod.GET)
    public AccountSettings retrieveAccountSettings(@AuthenticationPrincipal User user) {
        return investmentService.retrieveAccountSettings(user.getId());
    }
}
