package io.lucky.user.domain;

import java.time.LocalDateTime;

public class BaseDomain {
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    // getter, setter
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
