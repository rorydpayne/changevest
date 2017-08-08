package com.change.changevest.web.domain.service;

import com.change.changevest.web.domain.model.AccountSettings;

public interface AccountSettingsRepository {
    AccountSettings save(AccountSettings accountSettings);

    AccountSettings findById(Long accountSettingsId);
}
