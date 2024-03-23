package io.lucky.user.application.port;

import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;

public interface SearchTierPort {
    boolean existsByKeyAndValue(TierKey key, TierValue value);
}
