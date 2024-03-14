package io.lucky.user.application.service;

import io.lucky.user.application.port.SearchUserPort;
import io.lucky.user.application.query.SearchUserQuery;
import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;
import io.lucky.user.exception.DomainNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchUserService implements SearchUserQuery {

    private final SearchUserPort searchUserPort;

    @Override
    public User getUser(UserId userId) {
        return searchUserPort.findById(userId)
                .orElseThrow(() -> new DomainNotFoundException(User.class, userId.getId()));
    }
}
