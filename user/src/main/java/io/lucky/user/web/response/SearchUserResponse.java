package io.lucky.user.web.response;

import io.lucky.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchUserResponse {
    @Schema(description = "유저 ID", example = "1")
    private final Long id;
    @Schema(description = "이메일", example = "test@gmail.com")
    private String email;
    @Schema(description = "닉네임", example = "testName")
    private String nickname;
    public SearchUserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
