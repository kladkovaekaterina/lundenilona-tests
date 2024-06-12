package web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//not in use
@Data
public class AuthRequestModel {

    @JsonProperty("AUTH_FORM")
    String authForm;

    @JsonProperty("TYPE")
    String type;

    @JsonProperty("USER_LOGIN")
    String userLogin;

    @JsonProperty("USER_PASSWORD")
    String userPass;

    String login;
}