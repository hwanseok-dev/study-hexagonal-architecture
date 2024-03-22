package io.lucky.user.web.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    @Schema(description = "이메일", example = "test@gmail.com")
    private String email;
    @Schema(description = "닉네임", example = "testName")
    private String nickname;
    @Schema(description = "비밀번호", example = "testPasswor")
    private String password;
}
