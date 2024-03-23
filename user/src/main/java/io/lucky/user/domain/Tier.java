package io.lucky.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Tier extends BaseDomain {
    private final Long id;
    private final TierKey key;
    private final TierValue value;

    public static Tier newInstance(TierKey key, TierValue value) {
        return new Tier(null, key, value);
    }

    public static Tier fromEntity(Long id, TierKey key, TierValue value) {
        return new Tier(id, key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tier tier = (Tier) o;
        return Objects.equals(getId(), tier.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
