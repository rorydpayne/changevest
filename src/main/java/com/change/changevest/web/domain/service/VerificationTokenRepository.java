package com.change.changevest.web.domain.service;

import com.change.changevest.web.domain.model.VerificationToken;

public interface VerificationTokenRepository {
    VerificationToken findByToken(String token);
}
