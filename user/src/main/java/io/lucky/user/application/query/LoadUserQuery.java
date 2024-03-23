package io.lucky.user.application.query;

import io.lucky.user.domain.User;

public interface LoadUserQuery {
    User getOrThrowById(Long userId);
}
