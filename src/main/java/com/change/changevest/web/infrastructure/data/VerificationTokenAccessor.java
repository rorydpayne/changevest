package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.infrastructure.data.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenAccessor extends CrudRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
