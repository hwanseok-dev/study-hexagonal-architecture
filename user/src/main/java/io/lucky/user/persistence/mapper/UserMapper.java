package io.lucky.user.persistence.mapper;

import io.lucky.user.domain.User;
import io.lucky.user.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final TierMapper tierMapper;

    public User toDomain(UserEntity entity) {
        return User.fromEntity(
                entity.getId(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getPassword(),
                entity.getTierSet().stream()
                        .map(tierMapper::toDomain)
                        .collect(Collectors.toSet())
        );
    }

    public UserEntity toEntity(User domain){
        return new UserEntity(
                domain.getId(),
                domain.getEmail(),
                domain.getNickname(),
                domain.getPassword(),
                domain.getTierSet().stream()
                        .map(tierMapper::toEntity)
                        .collect(Collectors.toSet())
        );
    }

}
