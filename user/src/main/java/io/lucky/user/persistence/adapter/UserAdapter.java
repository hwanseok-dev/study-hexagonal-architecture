package io.lucky.user.persistence.adapter;

import io.lucky.user.application.port.CreateUserPort;
import io.lucky.user.application.port.SearchUserPort;
import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;
import io.lucky.user.persistence.entity.UserEntity;
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
    public UserId create(User user) {
        UserEntity entity = userMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(entity);
        return new UserId(savedEntity.getId());
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return userRepository.findById(userId.getId())
                .map(userMapper::toDomain);
    }
}
