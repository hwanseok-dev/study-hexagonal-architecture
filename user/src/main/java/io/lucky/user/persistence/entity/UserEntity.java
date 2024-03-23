package io.lucky.user.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String nickname;
    private String password;

    public UserEntity(Long idOrNull,
                      String email,
                      String nickname,
                      String password) {
        this.id = idOrNull;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }
}
