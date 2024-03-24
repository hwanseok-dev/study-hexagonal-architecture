package io.lucky.user.application.usecase;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AddTierCommand extends SelfValidating<AddTierCommand> {
    @NotNull
    private final Long userId;
    @NotNull
    private final Long tierId;
    public AddTierCommand(Long userId, Long tierId) {
        this.userId = userId;
        this.tierId = tierId;
        super.validateSelf();
    }
}
