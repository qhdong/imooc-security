package com.imooc.security.core.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrowserProperties {

    private SessionProperties session = new SessionProperties();

    private String signUpUrl = "/imooc-signUp.html";

    private String loginPage = "/imooc-signIn.html";

    private String signOutUrl;

    private LoginResponseType loginType = LoginResponseType.JSON;

    private int rememberMeSeconds = 3600;
}
