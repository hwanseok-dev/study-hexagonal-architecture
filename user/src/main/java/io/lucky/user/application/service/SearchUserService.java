package io.lucky.user.application.service;

import io.lucky.user.application.port.SearchUserPort;
import io.lucky.user.application.query.SearchUserQuery;
import io.lucky.user.domain.User;
import io.lucky.user.exception.DomainNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchUserService implements SearchUserQuery {
    private final SearchUserPort searchUserPort;
    @Override
    public User getOrThrowById(Long userId) {
        return searchUserPort.findByUserId(userId).orElseThrow(() -> new DomainNotFoundException(User.class, userId));
    }

    @Override
    public boolean existsByEmail(String email) {
        return searchUserPort.existsByEmail(email);
    }
}
