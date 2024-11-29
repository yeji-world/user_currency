package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDto {
    @NotBlank(message = "사용자의 이름을 입력해주세요.")
    @Size(min = 2, max = 5, message = "이름은 2~5글자 사이로 입력해주세요.")
    private String name;
    @NotBlank(message = "사용자의 이메일을 입력해주세요.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "올바른 이메일 형식을 입력해 주세요.")
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
