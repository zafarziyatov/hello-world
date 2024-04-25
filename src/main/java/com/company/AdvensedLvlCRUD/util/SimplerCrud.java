package com.company.AdvensedLvlCRUD.util;

import com.company.AdvensedLvlCRUD.dto.ResponseDto;

public interface SimplerCrud<K,V>{
    ResponseDto<V>created(V entity);
    ResponseDto<V>get(K entityId);
    ResponseDto<V>update(K entityId,V entity);
    ResponseDto<V>deleted(K entityId);

}
