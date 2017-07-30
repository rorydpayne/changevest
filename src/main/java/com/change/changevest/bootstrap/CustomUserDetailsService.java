package com.change.changevest.bootstrap;

import com.change.changevest.web.infrastructure.data.UserAccessor;
import com.change.changevest.web.infrastructure.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccessor userAccessor;

    @Autowired
    public CustomUserDetailsService(UserAccessor userAccessor) {
        this.userAccessor = userAccessor;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAccessor.findByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("User with email %s does not exist", username));

        return new UserRepositoryUserDetails(user);
    }
}
