package com.change.changevest.web.infrastructure.data.mapper;

import com.change.changevest.web.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AccountSettingsMapper accountSettingsMapper;

    public User fromDb(com.change.changevest.web.infrastructure.data.model.User dbUser) {
        if (dbUser == null)
            return null;
        User user = new User();
        user.setId(dbUser.getId());
        user.setFirstName(dbUser.getFirstName());
        user.setLastName(dbUser.getLastName());
        user.setEmail(dbUser.getEmail());
        user.setEnabled(dbUser.isEnabled());
        user.setPassword(dbUser.getPassword());
        user.setRoles(roleMapper.fromDb(dbUser.getRoles()));
        user.setAccountSettings(accountSettingsMapper.fromDb(dbUser.getAccountSettings()));
        return user;
    }

    public com.change.changevest.web.infrastructure.data.model.User fromDomain(User user) {
        if (user == null) {
            return null;
        }
        com.change.changevest.web.infrastructure.data.model.User dbUser =
                new com.change.changevest.web.infrastructure.data.model.User();
        dbUser.setId(user.getId());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setEmail(user.getEmail());
        dbUser.setPassword(user.getPassword());
        dbUser.setEnabled(user.isEnabled());
        dbUser.setRoles(roleMapper.fromDomain(user.getRoles()));
        dbUser.setAccountSettings(accountSettingsMapper.fromDomain(user.getAccountSettings()));
        return dbUser;
    }
}
