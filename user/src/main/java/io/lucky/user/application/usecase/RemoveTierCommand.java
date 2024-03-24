package io.lucky.user.application.usecase;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RemoveTierCommand extends SelfValidating<RemoveTierCommand> {
    @NotNull
    private final Long userId;
    @NotNull
    private final Long tierId;
    public RemoveTierCommand(Long userId, Long tierId) {
        this.userId = userId;
        this.tierId = tierId;
        super.validateSelf();
    }
}
