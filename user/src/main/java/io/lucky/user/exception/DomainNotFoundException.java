package io.lucky.user.exception;


import io.lucky.user.domain.BaseDomain;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(Class<? extends BaseDomain> domain, Long id) {
        super(String.format("error : DomainNotFound, id : %d, class : %s", id, domain.getName()));
    }

    public DomainNotFoundException(Class<? extends BaseDomain> domain, String message) {
        super(message);
    }
}
