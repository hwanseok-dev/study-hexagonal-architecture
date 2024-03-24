package io.lucky.user.persistence.adapter;

import io.lucky.user.application.port.CreateTierPort;
import io.lucky.user.application.port.SearchTierPort;
import io.lucky.user.domain.Tier;
import io.lucky.user.domain.TierKey;
import io.lucky.user.domain.TierValue;
import io.lucky.user.persistence.entity.TierEntity;
import io.lucky.user.persistence.mapper.TierMapper;
import io.lucky.user.persistence.repository.TierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class TierAdapter implements CreateTierPort, SearchTierPort {
    private final TierMapper tierMapper;
    private final TierRepository tierRepository;

    @Override
    public Long create(Tier tier) {
        TierEntity entity = tierMapper.toEntity(tier);
        TierEntity savedEntity = tierRepository.save(entity);
        return savedEntity.getId();
    }

    @Override
    public Optional<Tier> findOneById(Long id) {
        return tierRepository.findById(id)
                .map(tierMapper::toDomain);
    }

    @Override
    public boolean existsByKeyAndValue(TierKey key, TierValue value) {
        return tierRepository.existsByTierKeyAndTierValue(key, value);
    }
}
