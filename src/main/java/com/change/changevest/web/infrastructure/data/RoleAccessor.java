package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.infrastructure.data.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAccessor extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
