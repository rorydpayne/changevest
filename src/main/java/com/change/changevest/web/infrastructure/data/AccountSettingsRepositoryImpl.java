package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.domain.model.AccountSettings;
import com.change.changevest.web.domain.service.AccountSettingsRepository;
import com.change.changevest.web.infrastructure.data.mapper.AccountSettingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSettingsRepositoryImpl implements AccountSettingsRepository {

    @Autowired
    private AccountSettingsAccessor accountSettingsAccessor;

    @Autowired
    private AccountSettingsMapper accountSettingsMapper;

    @Override
    public AccountSettings save(AccountSettings accountSettings) {
        return accountSettingsMapper.fromDb(accountSettingsAccessor.save(accountSettingsMapper.fromDomain(accountSettings)));
    }

    @Override
    public AccountSettings findById(Long accountSettingsId) {
        return accountSettingsMapper.fromDb(accountSettingsAccessor.findOne(accountSettingsId));
    }
}
