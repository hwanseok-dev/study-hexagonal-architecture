package io.lucky.user.application.service;

import io.lucky.user.annotaion.IntegrationTestConfig;
import io.lucky.user.application.query.SearchUserQuery;
import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;
import io.lucky.user.util.UserTestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTestConfig
class CreateUserServiceTest {
    @Autowired
    private CreateUserService createUserService;
    @Autowired
    private SearchUserQuery searchUserQuery;

    @Test
    void create() {
        UserId userId = createUser();
        assertThat(userId).isNotNull();
    }

    @Test
    void createAndSearch(){
        UserId userId = createUser();
        User user = searchUserQuery.getUser(userId);
        assertThat(userId).isNotNull();
        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo(UserTestUtil.USER_EMAIL);
        assertThat(user.getNickname()).isEqualTo(UserTestUtil.USER_NICKNAME);
        assertThat(user.getPassword()).isEqualTo(UserTestUtil.USER_PASSWORD);
    }

    private UserId createUser() {
        CreateUserCommand command = new CreateUserCommand(
                UserTestUtil.USER_EMAIL,
                UserTestUtil.USER_NICKNAME,
                UserTestUtil.USER_PASSWORD);
        UserId userId = createUserService.create(command);
        return userId;
    }
}