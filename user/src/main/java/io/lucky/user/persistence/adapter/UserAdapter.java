package io.lucky.user.persistence.adapter;

import io.lucky.user.application.port.CreateUserPort;
import io.lucky.user.application.port.SearchUserPort;
import io.lucky.user.domain.User;
import io.lucky.user.persistence.entity.UserJpaEntity;
import io.lucky.user.persistence.mapper.UserMapper;
import io.lucky.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAdapter implements CreateUserPort, SearchUserPort {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Long create(User user) {
        UserJpaEntity entity = userMapper.toEntity(user);
        UserJpaEntity savedEntity = userRepository.save(entity);
        return savedEntity.getId();
    }

    @Override
    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDomain);
    }
}
