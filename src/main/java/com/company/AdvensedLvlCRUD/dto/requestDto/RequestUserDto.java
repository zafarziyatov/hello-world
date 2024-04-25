package com.company.AdvensedLvlCRUD.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Integer age;
}
