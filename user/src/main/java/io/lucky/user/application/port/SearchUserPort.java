package io.lucky.user.application.port;

import io.lucky.user.domain.User;

import java.util.Optional;

public interface SearchUserPort {
    Optional<User> findByUserId(Long userId);
}
