package io.lucky.user.web.controller;

import io.lucky.user.application.query.SearchUserQuery;
import io.lucky.user.application.usecase.CreateUserCommand;
import io.lucky.user.application.usecase.CreateUserUseCase;
import io.lucky.user.domain.User;
import io.lucky.user.web.request.CreateUserRequest;
import io.lucky.user.web.response.CreateUserResponse;
import io.lucky.user.web.response.RestResponse;
import io.lucky.user.web.response.SearchUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Tag(name = "user", description = "user API")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final SearchUserQuery searchUserQuery;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "유저 생성", description = "유저를 생성합니다")
    public RestResponse create(@RequestBody CreateUserRequest createUserRequest) {
        CreateUserCommand command = new CreateUserCommand(createUserRequest.getEmail(),
                createUserRequest.getNickname(),
                createUserRequest.getPassword());
        Long userId = createUserUseCase.create(command);
        return RestResponse.ok(new CreateUserResponse(userId));
    }

    @GetMapping(value = "/id/{id}")
    @Operation(summary = "유저 조회", description = "유저 상세 정보 조회")
    public RestResponse searchOne(@PathVariable Long id) {
        User user = searchUserQuery.getOrThrowById(id);
        return RestResponse.ok(new SearchUserResponse(user));
    }
}
