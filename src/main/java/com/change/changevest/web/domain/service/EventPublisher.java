package com.change.changevest.web.domain.service;

import com.change.changevest.web.domain.model.Event;

public interface EventPublisher {

    void publishEvent(Event event);
}
