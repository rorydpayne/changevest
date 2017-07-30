package com.change.changevest.web.infrastructure.notification.mapper;

import com.change.changevest.web.infrastructure.data.mapper.UserMapper;
import com.change.changevest.web.infrastructure.notification.model.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    @Autowired
    private UserMapper userMapper;

    public OnRegistrationCompleteEvent fromDomain(com.change.changevest.web.domain.model.Event event) {
        if (event instanceof com.change.changevest.web.domain.model.OnRegistrationCompleteEvent)
            return new OnRegistrationCompleteEvent(userMapper.fromDomain(event.getUser()), event.getLocale(), event.getAppUrl());
        else
            throw new IllegalArgumentException("Not a valid event");
    }
}
