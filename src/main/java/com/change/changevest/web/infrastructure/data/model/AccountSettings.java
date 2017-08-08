package com.change.changevest.web.infrastructure.data.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_settings")
public class AccountSettings {

    @Id
    @GeneratedValue
    private Long id;

    private String currencyCode;
    private String weeklyDepositCurrency;
    private Long weeklyDepositAmount;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean roundupsEnabled;

    public AccountSettings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getWeeklyDepositCurrency() {
        return weeklyDepositCurrency;
    }

    public void setWeeklyDepositCurrency(String weeklyDepositCurrency) {
        this.weeklyDepositCurrency = weeklyDepositCurrency;
    }

    public Long getWeeklyDepositAmount() {
        return weeklyDepositAmount;
    }

    public void setWeeklyDepositAmount(Long weeklyDepositAmount) {
        this.weeklyDepositAmount = weeklyDepositAmount;
    }

    public Boolean getRoundupsEnabled() {
        return roundupsEnabled;
    }

    public void setRoundupsEnabled(Boolean roundupsEnabled) {
        this.roundupsEnabled = roundupsEnabled;
    }
}
