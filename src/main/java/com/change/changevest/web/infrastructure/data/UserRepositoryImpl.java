package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.domain.model.User;
import com.change.changevest.web.domain.service.UserRepository;
import com.change.changevest.web.infrastructure.data.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserAccessor userAccessor;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        return userMapper.fromDb(userAccessor.save(userMapper.fromDomain(user)));
    }

    @Override
    public User getById(Long userId) {
        return userMapper.fromDb(userAccessor.findOne(userId));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.fromDb(userAccessor.findByEmail(email));
    }
}
