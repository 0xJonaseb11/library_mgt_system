package com.exam.library.email;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    ACTIVATE_ACCOUNT("activate_account"),
    RESET_PASSWORD("reset_password");
    private final String name;

    EmailTemplate(String name) {
        this.name = name;
    }
}
