package com.company.AdvensedLvlCRUD.dto.requestDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCardDto {

    private String cardFulName;
    private String carName;
    private Integer userId;
    private String cardCode;
}
