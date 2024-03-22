package io.lucky.user.web.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse {
    @Schema(description = "유저 ID", example = "1")
    private Long id;

    public CreateUserResponse(Long id) {
        this.id = id;
    }
}
