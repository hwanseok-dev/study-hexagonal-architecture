package io.lucky.user.exception;

import io.lucky.user.web.response.RestResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({
            ConstraintViolationException.class, // Command 클래스 SelfValidating 검증
            DomainNotFoundException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RestResponse badRequests(final HttpServletRequest req,
                                    final HttpServletResponse res,
                                    final Exception e) {
        return RestResponse.badRequest(e.getMessage());
    }

    @ExceptionHandler({
            RuntimeException.class,
            Exception.class
    })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResponse unexpectedException(final HttpServletRequest req,
                                                      final HttpServletResponse res,
                                                      final Exception e) {
        log.error(e.getMessage(), e);
        res.setStatus(500);
        return RestResponse.unknownError();
    }
}