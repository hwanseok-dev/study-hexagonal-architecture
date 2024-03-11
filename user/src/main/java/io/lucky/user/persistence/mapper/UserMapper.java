package io.lucky.user.persistence.mapper;

import io.lucky.user.domain.User;
import io.lucky.user.domain.UserId;
import io.lucky.user.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(UserEntity entity) {
        return new User(
                new UserId(entity.getId()),
                entity.getEmail(),
                entity.getNickname(),
                entity.getPassword()
        );
    }

    public UserEntity toEntity(User domain){
        UserId id = domain.getId();
        return new UserEntity(
                id == null ? null : id.getId(),
                domain.getEmail(),
                domain.getNickname(),
                domain.getPassword()
        );
    }
}
