package io.lucky.user.application.port;

import io.lucky.user.domain.Tier;

public interface CreateTierPort {
    Long create(Tier tier);
}
