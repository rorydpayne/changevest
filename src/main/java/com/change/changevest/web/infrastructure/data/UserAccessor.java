package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.infrastructure.data.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserAccessor extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
