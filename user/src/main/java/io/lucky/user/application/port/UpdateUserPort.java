package io.lucky.user.application.port;

import io.lucky.user.domain.Tier;
import io.lucky.user.domain.User;

public interface UpdateUserPort {
    boolean addTier(User user, Tier tier);
    boolean removeTier(User user, Tier tier);
}
