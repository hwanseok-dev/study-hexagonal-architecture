package io.lucky.user.application.service;

import io.lucky.user.annotaion.IntegrationTestConfig;
import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.domain.UserId;
import io.lucky.user.util.UserTestUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTestConfig
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void create() {
        CreateUserCommand command = new CreateUserCommand(
                UserTestUtil.USER_EMAIL,
                UserTestUtil.USER_NICKNAME,
                UserTestUtil.USER_PASSWORD);
        UserId userId = userService.create(command);
        assertThat(userId).isNotNull();
    }
}