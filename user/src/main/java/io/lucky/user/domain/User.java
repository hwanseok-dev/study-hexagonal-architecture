package io.lucky.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User extends BaseDomain {
    private final Long id;
    private final String email;
    private final String nickname;
    private final String password;

    public static User newInstance(String email, String nickname, String password){
        return new User(null, email, nickname, password);
    }
}
