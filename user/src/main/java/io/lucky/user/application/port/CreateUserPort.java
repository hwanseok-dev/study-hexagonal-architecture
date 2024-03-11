package io.lucky.user.application.port;

import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;

public interface CreateUserPort {
    UserId create(User user);
}
