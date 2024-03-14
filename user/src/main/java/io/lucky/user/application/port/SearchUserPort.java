package io.lucky.user.application.port;

import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;

import java.util.Optional;

public interface SearchUserPort {
    Optional<User> findById(UserId userId);
}
