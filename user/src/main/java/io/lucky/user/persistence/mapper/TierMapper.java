package io.lucky.user.persistence.mapper;

import io.lucky.user.domain.Tier;
import io.lucky.user.persistence.entity.TierEntity;
import org.springframework.stereotype.Component;

@Component
public class TierMapper {
    public Tier toDomain(TierEntity entity) {
        return Tier.fromEntity(
                entity.getId(),
                entity.getTierKey(),
                entity.getTierValue()
        );
    }

    public TierEntity toEntity(Tier domain){
        return new TierEntity(
                domain.getId(),
                domain.getKey(),
                domain.getValue()
        );
    }
}
