package com.change.changevest.web.infrastructure.notification;

import com.change.changevest.web.domain.model.Event;
import com.change.changevest.web.domain.service.EventPublisher;
import com.change.changevest.web.infrastructure.notification.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherImpl implements EventPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private EventMapper mapper;

    @Override
    public void publishEvent(Event event) {
        publisher.publishEvent(mapper.fromDomain(event));
    }
}
