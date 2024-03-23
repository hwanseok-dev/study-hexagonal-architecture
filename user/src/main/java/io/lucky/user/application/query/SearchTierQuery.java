package io.lucky.user.application.query;

import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;

public interface SearchTierQuery {
    boolean existsByKeyAndValue(TierKey key, TierValue value);
}
