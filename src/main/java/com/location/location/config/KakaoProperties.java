package com.location.location.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kakao")
public class KakaoProperties {

    private Auth auth = new Auth();
    private Client client = new Client();
    private Redirect redirect = new Redirect();

    public Auth getAuth() {
        return auth;
    }

    public Client getClient() {
        return client;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public static class Auth {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Client {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Redirect {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
