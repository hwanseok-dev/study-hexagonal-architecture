package io.lucky.user.application.service;

import io.lucky.user.application.port.CreateUserPort;
import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.application.usecase.CreateUserUseCase;
import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;
    @Override
    public UserId create(CreateUserCommand command) {
        User user = new User(null,
                command.getEmail(),
                command.getNickname(),
                command.getPassword());
        return createUserPort.create(user);
    }
}
