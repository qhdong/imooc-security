package com.imooc.security.core.properties;

import lombok.Data;

@Data
public class SessionProperties {

    /**
     * 同一个用户在系统中的最大session数量
     */
    private int maximumSessions = 1;

    private boolean maxSessionsPreventsLogin;

    private String sessionInvalidUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;
}
