package io.lucky.user.exception;


import io.lucky.user.domain.BaseDomain;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(Class<? extends BaseDomain> domain, Long id) {
        super(String.format("error : DomainNotFound, domainName : %s, id : %d, ", domain.getSimpleName(), id));
    }

    public DomainNotFoundException(Class<? extends BaseDomain> domain, String message) {
        super(message);
    }
}
