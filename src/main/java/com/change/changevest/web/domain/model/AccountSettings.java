package com.change.changevest.web.domain.model;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

public class AccountSettings {

    private Long id;
    private CurrencyUnit currencyUnit;
    private MonetaryAmount weeklyDeposit;
    private Boolean roundupsEnabled;
    private BankAccount account;

    public AccountSettings() {
        this.currencyUnit = Monetary.getCurrency("GBP");
        this.weeklyDeposit = Monetary.getDefaultAmountFactory()
                .setCurrency(this.currencyUnit).setNumber(0).create();
        this.roundupsEnabled = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyUnit getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyCode) {
        this.currencyUnit = Monetary.getCurrency(currencyCode);
    }

    public MonetaryAmount getWeeklyDeposit() {
        return weeklyDeposit;
    }

    public void setWeeklyDeposit(MonetaryAmount weeklyDeposit) {
        this.weeklyDeposit = weeklyDeposit;
    }

    public Boolean getRoundupsEnabled() {
        return roundupsEnabled;
    }

    public void setRoundupsEnabled(Boolean roundupsEnabled) {
        this.roundupsEnabled = roundupsEnabled;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountSettings that = (AccountSettings) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
