package io.lucky.user.application.service;

import io.lucky.user.annotaion.IntegrationTestConfig;
import io.lucky.user.exception.DomainNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@IntegrationTestConfig
class SearchUserServiceTest {
    @Autowired
    private LoadUserService searchUserService;

    @Test
    void searchUserNotExists(){
        assertThatThrownBy(() -> searchUserService.getUser(1L))
                .isInstanceOf(DomainNotFoundException.class);
    }
}