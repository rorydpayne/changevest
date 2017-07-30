package com.change.changevest.web.domain.model;

import java.util.Locale;

public class OnRegistrationCompleteEvent extends Event {

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
        super(user, locale, appUrl);
    }
}
