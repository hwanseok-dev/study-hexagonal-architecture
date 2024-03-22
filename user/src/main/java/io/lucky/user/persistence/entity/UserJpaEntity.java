package io.lucky.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String nickname;
    private String password;

    public UserJpaEntity(Long idOrNull,
                         String email,
                         String nickname,
                         String password) {
        this.id = idOrNull;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }
}
