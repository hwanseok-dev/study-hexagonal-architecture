package io.lucky.user.persistence.mapper;

import io.lucky.user.domain.User;
import io.lucky.user.persistence.entity.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserJpaEntity entity) {
        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getPassword()
        );
    }

    public UserJpaEntity toEntity(User domain){
        return new UserJpaEntity(
                domain.getId(),
                domain.getEmail(),
                domain.getNickname(),
                domain.getPassword()
        );
    }
}
