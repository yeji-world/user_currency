package com.sparta.currency_user.enums;

import lombok.Getter;

@Getter
public enum Status {
    NORMAL("normal"),
    CANCELLED("canceled");

    private final String status;
    Status(String status) { this.status = status; }

    public String getStatus() {
        return status;
    }
}
