package com.company.AdvensedLvlCRUD.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {


    private boolean success;

    private String message;
    private int code;

    private T contend;

    private List<ErrorDto> errorList;

}
