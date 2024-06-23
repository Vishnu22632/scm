package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.StandardException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Min 3 and Max 20 character is required")
    private String name;
    
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be 6 characters long")
    private String password;
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is required")
    private String email;
    @Size(min = 8, max = 10, message = "Invalid Number")
    private String phoneNumber;
    @NotBlank(message = "About is required")
    private String about;
}
