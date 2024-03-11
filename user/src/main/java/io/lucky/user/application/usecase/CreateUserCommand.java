package io.lucky.user.application.usecase;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CreateUserCommand extends SelfValidating<CreateUserCommand> {
    @Email
    private final String email;
    @Length(min = 3)
    private final String nickname;
    @Length(min = 10)
    private final String password;
    public CreateUserCommand(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        super.validateSelf();
    }
}
