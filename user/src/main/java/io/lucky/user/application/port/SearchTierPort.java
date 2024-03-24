package io.lucky.user.application.port;

import io.lucky.user.domain.Tier;
import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;

import java.util.Optional;

public interface SearchTierPort {
    Optional<Tier> findOneById(Long id);
    boolean existsByKeyAndValue(TierKey key, TierValue value);
}
