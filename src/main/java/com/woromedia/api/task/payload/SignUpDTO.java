package com.woromedia.api.task.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SignUpDTO {


    @NotNull(message = "Please enter a valid username.")
    private String username;

    @NotNull(message = "Please enter a valid email.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter a valid password.")
    private String password;
}
