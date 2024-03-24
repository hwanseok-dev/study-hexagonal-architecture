package io.lucky.user.application.query;

import io.lucky.user.domain.Tier;
import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;

public interface SearchTierQuery {
    Tier getOrThrowById(Long id);
    boolean existsByKeyAndValue(TierKey key, TierValue value);
}
