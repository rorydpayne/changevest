package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.domain.model.VerificationToken;
import com.change.changevest.web.domain.service.VerificationTokenRepository;
import com.change.changevest.web.infrastructure.data.mapper.VerificationTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

    @Autowired
    private VerificationTokenAccessor accessor;

    @Autowired
    private VerificationTokenMapper mapper;

    @Override
    public VerificationToken findByToken(String token) {
        return mapper.fromDb(accessor.findByToken(token));
    }
}
