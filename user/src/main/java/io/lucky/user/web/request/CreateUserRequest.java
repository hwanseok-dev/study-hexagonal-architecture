package io.lucky.user.web.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String email;
    private String nickname;
    private String password;
}
