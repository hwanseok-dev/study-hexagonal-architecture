package io.lucky.user.web;

import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.application.usecase.CreateUserUseCase;
import io.lucky.user.domain.UserId;
import io.lucky.user.web.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping("/v1/create")
    public ResponseEntity<UserId> create(@RequestBody CreateUserRequest createUserRequest) {
        CreateUserCommand command = new CreateUserCommand(createUserRequest.getEmail(),
                createUserRequest.getNickname(),
                createUserRequest.getPassword());
        UserId userId = createUserUseCase.create(command);
        return ResponseEntity.ok(userId);
    }
}
