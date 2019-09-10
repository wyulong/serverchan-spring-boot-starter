package com.lnold.serverchan;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.serverchan")
public class ServerchanProperties {

    private String sckey = "";

    // Getter & Setter

    public String getSckey() {
        return sckey;
    }

    public void setSckey(String sckey) {
        this.sckey = sckey;
    }
}
