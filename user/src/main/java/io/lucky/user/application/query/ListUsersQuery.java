package io.lucky.user.application.query;

import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;

import java.util.List;

public interface ListUsersQuery {
    List<User> getUser(List<UserId> userId);
}
