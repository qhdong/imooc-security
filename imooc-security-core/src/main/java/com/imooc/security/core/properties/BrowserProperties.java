package com.imooc.security.core.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    private LoginResponseType loginType = LoginResponseType.JSON;

    private int rememberMeSeconds = 3600;
}
