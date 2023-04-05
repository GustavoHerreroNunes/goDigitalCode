package com.fiap.br.keycloak;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyKeycloak {

    private final String serverUrl;
    private final String realm;
    private final String clientId;
    private final String clientSecret;

    public MyKeycloak(@Value("${keycloak.auth-server-url}") String serverUrl,
                      @Value("${keycloak.realm}") String realm,
                      @Value("${keycloak.resource}") String clientId,
                      @Value("${keycloak.credentials.secret}") String clientSecret) {
        this.serverUrl = serverUrl;
        this.realm = realm;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public AccessTokenResponse authenticate(String username, String password) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(username)
                .password(password)
                .grantType("password")
                .build();

        return keycloak.tokenManager().grantToken();
    }
}
