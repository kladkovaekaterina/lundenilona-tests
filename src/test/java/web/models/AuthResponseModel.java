package web.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//not in use
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponseModel {

    String login, message, type;

    @JsonProperty("error_type")
    String errorType;
}