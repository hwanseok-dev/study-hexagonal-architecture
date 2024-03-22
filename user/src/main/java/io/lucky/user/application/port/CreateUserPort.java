package io.lucky.user.application.port;

import io.lucky.user.domain.User;

public interface CreateUserPort {
    Long create(User user);
}
