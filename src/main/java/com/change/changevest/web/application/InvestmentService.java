package com.change.changevest.web.application;

import com.change.changevest.web.domain.model.AccountSettings;
import com.change.changevest.web.domain.model.User;
import com.change.changevest.web.domain.model.exception.EntityNotFoundException;
import com.change.changevest.web.domain.service.AccountSettingsRepository;
import com.change.changevest.web.domain.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InvestmentService {

    @Autowired
    private AccountSettingsRepository accountSettingsRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public AccountSettings updateAccountSettings(Long userId, AccountSettings accountSettings) {
        User currentUser = userRepository.getById(userId);
        AccountSettings settings = accountSettingsRepository.findById(currentUser.getAccountSettings().getId());
        accountSettings.setId(settings.getId());
        return accountSettingsRepository.save(accountSettings);
    }

    @Transactional
    public AccountSettings retrieveAccountSettings(Long userId) {
        User currentUser = userRepository.getById(userId);
        return accountSettingsRepository.findById(currentUser.getAccountSettings().getId());
    }
}
