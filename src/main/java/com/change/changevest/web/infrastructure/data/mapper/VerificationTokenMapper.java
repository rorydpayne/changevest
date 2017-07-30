package com.change.changevest.web.infrastructure.data.mapper;

import com.change.changevest.web.domain.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenMapper {

    @Autowired
    private UserMapper userMapper;

    public VerificationToken fromDb(com.change.changevest.web.infrastructure.data.model.VerificationToken dbToken) {
        if (dbToken == null)
            return null;
        VerificationToken token = new VerificationToken(userMapper.fromDb(dbToken.getUser()));
        token.setId(dbToken.getId());
        token.setToken(dbToken.getToken());
        token.setExpiryDate(dbToken.getExpiryDate());
        return token;
    }

    public com.change.changevest.web.infrastructure.data.model.VerificationToken fromDomain(VerificationToken token) {
        if (token == null)
            return null;
        com.change.changevest.web.infrastructure.data.model.VerificationToken dbToken =
                new com.change.changevest.web.infrastructure.data.model.VerificationToken(userMapper.fromDomain(token.getUser()), token.getToken());
        dbToken.setId(token.getId());
        dbToken.setExpiryDate(token.getExpiryDate());
        return dbToken;
    }
}
