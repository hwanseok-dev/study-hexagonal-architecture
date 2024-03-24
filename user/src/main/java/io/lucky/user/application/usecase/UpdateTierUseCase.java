package io.lucky.user.application.usecase;

public interface UpdateTierUseCase {
    boolean add(AddTierCommand command);
    boolean remove(RemoveTierCommand command);
}
