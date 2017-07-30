package com.change.changevest.bootstrap;

import com.change.changevest.web.infrastructure.data.UserAccessor;
import com.change.changevest.web.infrastructure.data.model.Role;
import com.change.changevest.web.infrastructure.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

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

        UserRepositoryUserDetails userDetails =  new UserRepositoryUserDetails(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.isEnabled()
        );

        for(Role role : user.getRoles()) {
            userDetails.addRole(role.getName());
        }
        return  userDetails;
    }

    private class UserRepositoryUserDetails implements UserDetails, Serializable {
        private static final long serialVersionUID = 1L;

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private List<GrantedAuthority> roles;
        private String password;
        private Boolean enabled;

        UserRepositoryUserDetails(Long id,
                String firstName,
                String lastName,
                String email,
                String password,
                Boolean enabled) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.enabled = enabled;
            this.roles = new ArrayList<>();
        }

        public void addRole(String name) {
            this.roles.add(new SimpleGrantedAuthority("ROLE_" + name));
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.roles;
        }

        @Override
        public String getPassword() {
            return this.password;
        }

        @Override
        public String getUsername() {
            return this.email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return this.enabled;
        }
    }
}
