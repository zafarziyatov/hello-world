package com.company.AdvensedLvlCRUD.util;

import com.company.AdvensedLvlCRUD.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface SimpleRequestCrud<K, RQ, RS> {
    ResponseEntity<ResponseDto<RS>> created(RQ entity);

    ResponseEntity<ResponseDto<RS>> get(K entityId);

    ResponseEntity<ResponseDto<RS>> update(K entityId, RQ entity);

    ResponseEntity<ResponseDto<RS>> deleted(K entityId);
}
