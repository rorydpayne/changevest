package com.change.changevest.web.infrastructure.data;

import com.change.changevest.web.infrastructure.data.model.AccountSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSettingsAccessor extends CrudRepository<AccountSettings, Long> {


}
