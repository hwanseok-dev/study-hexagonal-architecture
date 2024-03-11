package io.lucky.user.application.usecase;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
public class CreateUserCommand extends SelfValidating<CreateUserCommand> {

    @Email
    private final String email;
    @Min(3)
    private final String nickname;
    @Min(10)
    private final String password;

    public CreateUserCommand(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        super.validateSelf();
    }
}
