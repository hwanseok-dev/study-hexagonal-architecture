package io.lucky.user.application.usecase;

import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateTierCommand extends SelfValidating<CreateTierCommand> {
    @NotNull
    private final TierKey key;
    @NotNull
    private final TierValue value;
    public CreateTierCommand(TierKey key, TierValue value) {
        this.key = key;
        this.value = value;
        super.validateSelf();
    }
}
