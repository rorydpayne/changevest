package com.change.changevest.web.application;

import com.change.changevest.web.domain.model.OnRegistrationCompleteEvent;
import com.change.changevest.web.domain.model.Role;
import com.change.changevest.web.domain.model.User;
import com.change.changevest.web.domain.model.VerificationToken;
import com.change.changevest.web.domain.model.exception.EmailAlreadyRegisteredException;
import com.change.changevest.web.domain.model.exception.VerificationTokenExpiredException;
import com.change.changevest.web.domain.model.exception.VerificationTokenInvalidException;
import com.change.changevest.web.domain.service.EventPublisher;
import com.change.changevest.web.domain.service.UserRepository;
import com.change.changevest.web.domain.service.VerificationTokenRepository;
import com.change.changevest.web.ui.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EventPublisher eventPublisher;

    @Transactional
    public User createUserAccount(UserDTO userDTO, Locale locale, String appUrl) throws EmailAlreadyRegisteredException {
        if (emailAlreadyRegistered(userDTO.getEmail())) {
            throw new EmailAlreadyRegisteredException();
        }
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.addRole(Role.USER);
        User registered = userRepository.save(user);
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, locale, appUrl));
        return registered;
    }

    private boolean emailAlreadyRegistered(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Transactional
    public void confirmRegistration(String token) throws VerificationTokenInvalidException, VerificationTokenExpiredException {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken == null) {
            throw new VerificationTokenInvalidException();
        }
        User user = verificationToken.getUser();
        // TODO: Expiry. Requires endpoint to get new/refresh token
//        Calendar cal = Calendar.getInstance();
//        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
//            throw new VerificationTokenExpiredException();
//        }
        user.enable();
        userRepository.save(user);
    }
}
