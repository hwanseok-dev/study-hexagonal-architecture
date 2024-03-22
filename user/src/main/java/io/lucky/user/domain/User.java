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
}
