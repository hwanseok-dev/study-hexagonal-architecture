package io.lucky.user.application.query;

import io.lucky.user.domain.UserId;

public interface GetUserStatQuery {
    Integer getUserLoginCountInRecentHours(UserId userId, int hours);
}
