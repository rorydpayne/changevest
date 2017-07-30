package com.change.changevest.web.domain.service;

import com.change.changevest.web.domain.model.User;

public interface UserRepository {
    User save(User user);

    User getById(Long userId);

    User findByEmail(String email);
}
