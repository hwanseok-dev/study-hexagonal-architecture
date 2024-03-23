package io.lucky.user.persistence.repository;

import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;
import io.lucky.user.persistence.entity.TierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TierRepository extends JpaRepository<TierEntity, Long> {
    boolean existsByTierKeyAndTierValue(TierKey key, TierValue value);
}
