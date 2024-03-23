package io.lucky.user.domain;

import io.lucky.user.exception.BusinessException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.*;

@RequiredArgsConstructor
@Getter
@Slf4j
public class User extends BaseDomain {
    private static final int MAX_TIER_SIZE = 5;

    private final Long id;
    private final String email;
    private final String nickname;
    private final String password;
    private Set<Tier> tierSet = new HashSet<>();

    public static User newInstance(String email,
                                   String nickname,
                                   String password){
        return new User(null, email, nickname, password);
    }

    public static User fromEntity(Long id,
                                  String email,
                                  String nickname,
                                  String password,
                                  Set<Tier> tierSet){
        User user = new User(id, email, nickname, password);
        user.tierSet = tierSet;
        return user;
    }

    public void addTier(Tier tier){
        int tierSize = tierSet.size();
        if (tierSize >= MAX_TIER_SIZE) {
            log.error("msg : {}, userId : {}, oldSize : {}", "tierMaxSizeError", id, tierSize);
            throw new BusinessException("Max tier size is " + MAX_TIER_SIZE);
        }
        tierSet.add(tier);
    }

    public void removeTier(Tier tier){
        Assert.isTrue(tierSet.contains(tier), "Remove tier not exists");
        log.info("msg : {}, userId : {}, tierId : {}", "removeTier", id, tier.getId());
        tierSet.remove(tier);
    }
}
