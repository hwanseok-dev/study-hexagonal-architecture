package io.lucky.user.application.query;

import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;

public interface SearchUserQuery {
    User getUser(UserId userId);
}
