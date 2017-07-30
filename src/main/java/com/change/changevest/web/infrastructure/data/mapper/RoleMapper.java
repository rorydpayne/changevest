package com.change.changevest.web.infrastructure.data.mapper;

import com.change.changevest.web.domain.model.Role;
import com.change.changevest.web.infrastructure.data.RoleAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class RoleMapper {

    @Autowired
    private RoleAccessor roleAccessor;

    List<Role> fromDb(Set<com.change.changevest.web.infrastructure.data.model.Role> dbRoles) {
        return dbRoles.stream().map(role -> Role.fromName(role.getName())).collect(Collectors.toList());
    }

    Set<com.change.changevest.web.infrastructure.data.model.Role> fromDomain(List<Role> roles) {
        return roles.stream().map(role -> {
            com.change.changevest.web.infrastructure.data.model.Role r = roleAccessor.findByName(role.getName());
            if (r == null) {
                r = roleAccessor.save(new com.change.changevest.web.infrastructure.data.model.Role(role.getName()));
            }
            return r;
        }).collect(Collectors.toSet());
    }
}
