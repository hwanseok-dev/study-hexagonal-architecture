package io.lucky.user.application.service;

import io.lucky.user.application.port.CreateUserPort;
import io.lucky.user.application.query.SearchUserQuery;
import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.application.usecase.CreateUserUseCase;
import io.lucky.user.domain.User;
import io.lucky.user.exception.BusinessException;
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
    private final SearchUserQuery searchUserQuery;
    @Override
    public Long create(CreateUserCommand command) {
        User user = User.newInstance(command.getEmail(), command.getNickname(), command.getPassword());
        boolean existsByEmail = searchUserQuery.existsByEmail(user.getEmail());
        if (existsByEmail) {
            throw new BusinessException("User with email already exists. email : " + user.getEmail());
        }
        Long userId = createUserPort.create(user);
        log.info("msg : createUser, userId : {}, email : {}, nickname : {}",
                userId, user.getEmail(), user.getNickname());
        return userId;
    }
}
