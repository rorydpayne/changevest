package com.change.changevest.web.domain.model;

import java.util.Locale;

public abstract class Event {

    private User user;
    private Locale locale;
    private String appUrl;

    Event(User user, Locale locale, String appUrl) {
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public User getUser() {
        return user;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getAppUrl() {
        return appUrl;
    }
}
