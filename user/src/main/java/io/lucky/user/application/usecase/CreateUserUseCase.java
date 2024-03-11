package io.lucky.user.application.usecase;

import io.lucky.user.domain.UserId;

public interface CreateUserUseCase {
    UserId create(CreateUserCommand command);
}
