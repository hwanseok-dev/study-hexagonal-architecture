package io.lucky.user.application.service;

import io.lucky.user.application.port.SearchTierPort;
import io.lucky.user.application.query.SearchTierQuery;
import io.lucky.user.domain.Tier;
import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;
import io.lucky.user.exception.DomainNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchTierService implements SearchTierQuery {
    private final SearchTierPort searchTierPort;
    @Override
    public Tier getOrThrowById(Long id) {
        return searchTierPort.findOneById(id).orElseThrow(() -> new DomainNotFoundException(Tier.class, id));
    }
    @Override
    public boolean existsByKeyAndValue(TierKey key, TierValue value) {
        return searchTierPort.existsByKeyAndValue(key, value);
    }
}
