package com.change.changevest.web.domain.model;

import java.util.Date;

public class VerificationToken {

    private Long id;
    private String token;
    private User user;
    private Date expiryDate;

    public VerificationToken(User user) {
        this.user = user;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }


    public String getToken() {
        return token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
