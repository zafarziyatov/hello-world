package com.company.AdvensedLvlCRUD.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUserDto {
    @NotNull(message = "Firstname cannot be null")
    @NotEmpty(message = "Firstname cannot be empty")
    private String firstname;

    @NotBlank(message = "Lastname cannot be null or empty")
    private String lastname;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be null or empty")
    private String email;

    @NotBlank(message = "Password cannot be null or empty")
    @Size(min = 8, max = 16, message = "Incorrect password size")
    private String password;

    @Max(value = 150, message = "Age must be less than 150")
    @Min(value = 1, message = "Age must be more than 1")
    @NotNull(message = "Age cannot be null")
    private Integer age;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Set<ResponseCardDto> cards;
}
