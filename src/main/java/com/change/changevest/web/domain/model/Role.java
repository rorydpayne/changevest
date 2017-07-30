package com.change.changevest.web.domain.model;

public enum Role {
    USER("USER");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Role fromName(String name) {
        for (Role role: Role.values()) {
            if (role.name.equalsIgnoreCase(name))
                return role;
        }
        return null;
    }
}
