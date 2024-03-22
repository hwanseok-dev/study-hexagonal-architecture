package io.lucky.user.web;

import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.application.usecase.CreateUserUseCase;
import io.lucky.user.web.request.CreateUserRequest;
import io.lucky.user.web.response.CreateUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "user", description = "user API")
public class UserController {
    @PostMapping(value = "/v1/create")
    @Operation(summary = "유저 생성", description = "사용자의 입력을 받아 유저를 생성합니다")
    public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest createUserRequest) {
        CreateUserCommand command = new CreateUserCommand(createUserRequest.getEmail(),
                createUserRequest.getNickname(),
                createUserRequest.getPassword());
        Long userId = createUserUseCase.create(command);
        return ResponseEntity.ok(new CreateUserResponse(userId));
    }

    private final CreateUserUseCase createUserUseCase;
}
