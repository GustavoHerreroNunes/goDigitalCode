package com.fiap.br.login;

import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.token.TokenManager;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    //@Autowired
    private Keycloak keycloak;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {

        UserRepresentation userRep = new UserRepresentation();
        userRep.setUsername(user.getUsername());
        userRep.setEmail(user.getEmail());
        userRep.setEnabled(true);


        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(user.getPassword());
        credential.setTemporary(false);
        userRep.setCredentials(List.of(credential));

        userRep.setFirstName(user.getFirstName());
        userRep.setLastName(user.getLastName());

        Response response = keycloak.realm("myrealm").users().create(userRep);
        if (response.getStatus() == 201) {
            String userId = CreatedResponseUtil.getCreatedId(response);
            return ResponseEntity.ok("User created successfully with id: " + userId);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody User user) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(user.getPassword());
        credential.setTemporary(false);

        TokenManager tokenManager = keycloak.tokenManager();
        try {
            AccessTokenResponse tokenResponse = tokenManager.grantToken();
            return ResponseEntity.ok(tokenResponse.getToken());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    private String getCreatedId(Response response) {
        String[] locationParts = response.getLocation().getPath().split("/");
        return locationParts[locationParts.length - 1];
    }
}
