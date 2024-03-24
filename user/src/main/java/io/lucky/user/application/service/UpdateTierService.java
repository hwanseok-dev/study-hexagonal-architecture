package io.lucky.user.application.service;

import io.lucky.user.application.port.UpdateUserPort;
import io.lucky.user.application.query.SearchTierQuery;
import io.lucky.user.application.query.SearchUserQuery;
import io.lucky.user.application.usecase.AddTierCommand;
import io.lucky.user.application.usecase.RemoveTierCommand;
import io.lucky.user.application.usecase.UpdateTierUseCase;
import io.lucky.user.domain.Tier;
import io.lucky.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UpdateTierService implements UpdateTierUseCase {
    private final SearchUserQuery searchUserQuery;
    private final SearchTierQuery searchTierQuery;
    private final UpdateUserPort updateUserPort;

    @Override
    public boolean add(AddTierCommand command) {
        User user = searchUserQuery.getOrThrowById(command.getUserId());
        Tier tier = searchTierQuery.getOrThrowById(command.getTierId());
        user.addTier(tier);
        updateUserPort.addTier(user, tier);
        return true;
    }

    @Override
    public boolean remove(RemoveTierCommand command) {
        User user = searchUserQuery.getOrThrowById(command.getUserId());
        Tier tier = searchTierQuery.getOrThrowById(command.getTierId());
        user.removeTier(tier);
        return true;
    }
}
