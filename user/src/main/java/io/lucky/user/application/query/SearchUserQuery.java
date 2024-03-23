package io.lucky.user.application.query;

import io.lucky.user.domain.User;

public interface SearchUserQuery {
    User getOrThrowById(Long userId);
    boolean existsByEmail(String email);
}
