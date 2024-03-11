package io.lucky.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {
    private final UserId id;
    private final String email;
    private final String nickname;
    private final String password;
}
