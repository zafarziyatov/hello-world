package com.company.AdvensedLvlCRUD.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.ru.INN;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCardDto {
    private Integer cardId;
    @NotBlank(message = "Card User's full name cannot be null or empty")
    private String cardFulName;

    @NotBlank(message = "Card name cannot be null or empty")
    private String cardName;

    @NotNull(message = "User id of card owner cannot be or empty ")
    private Integer userId;

    @NotBlank(message = "Card code cannot be or empty")
    private String cardCode;


    private Set<ResponseUserDto> users;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


}
