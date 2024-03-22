package io.lucky.user.application.service;

import io.lucky.user.application.port.CreateUserPort;
import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.application.usecase.CreateUserUseCase;
import io.lucky.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;
    @Override
    public Long create(CreateUserCommand command) {
        User user = new User(null,
                command.getEmail(),
                command.getNickname(),
                command.getPassword());
        log.info("msg : {}, email : {}, nickname :{}, pwd : {}",
                "createUser", command.getEmail(), command.getNickname(),  command.getPassword());
        return createUserPort.create(user);
    }
}
