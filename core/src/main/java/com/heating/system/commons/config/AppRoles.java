package com.heating.system.commons.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppRoles {
    public static final String USER = "hasRole('USER')";
    public static final String ADMIN = "hasRole('ADMIN')";
}
