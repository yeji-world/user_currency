package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @NotBlank(message = "사용자의 이메일을 입력해주세요.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "올바른 이메일 형식을 입력해 주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 6, message = "비밀번호는 6자리 이상으로 입력해주세요.")
    private String password;
}
