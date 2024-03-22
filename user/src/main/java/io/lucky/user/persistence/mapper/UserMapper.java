package io.lucky.user.persistence.mapper;

import io.lucky.user.domain.User;
import io.lucky.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getPassword()
        );
    }

    public UserEntity toEntity(User domain){
        return new UserEntity(
                domain.getId(),
                domain.getEmail(),
                domain.getNickname(),
                domain.getPassword()
        );
    }
}
