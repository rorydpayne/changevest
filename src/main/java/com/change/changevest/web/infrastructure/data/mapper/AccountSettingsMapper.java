package com.change.changevest.web.infrastructure.data.mapper;

import com.change.changevest.web.domain.model.AccountSettings;
import org.springframework.stereotype.Service;

import javax.money.Monetary;

@Service
public class AccountSettingsMapper {

    public AccountSettings fromDb(com.change.changevest.web.infrastructure.data.model.AccountSettings dbSettings) {
        AccountSettings settings = new AccountSettings();
        settings.setCurrencyUnit(dbSettings.getCurrencyCode());
        settings.setRoundupsEnabled(dbSettings.getRoundupsEnabled());
        settings.setWeeklyDeposit(Monetary.getDefaultAmountFactory()
                .setCurrency(dbSettings.getWeeklyDepositCurrency())
                .setNumber(dbSettings.getWeeklyDepositAmount()).create());
        return settings;
    }

    public com.change.changevest.web.infrastructure.data.model.AccountSettings fromDomain(AccountSettings settings) {
        com.change.changevest.web.infrastructure.data.model.AccountSettings dbSettings
                = new com.change.changevest.web.infrastructure.data.model.AccountSettings();
        dbSettings.setCurrencyCode(settings.getCurrencyUnit().getCurrencyCode());
        dbSettings.setWeeklyDepositAmount(settings.getWeeklyDeposit().getNumber().longValueExact());
        dbSettings.setWeeklyDepositCurrency(settings.getWeeklyDeposit().getCurrency().getCurrencyCode());
        dbSettings.setRoundupsEnabled(settings.getRoundupsEnabled());
        return dbSettings;
    }
}
