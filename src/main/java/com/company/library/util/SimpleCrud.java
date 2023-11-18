package com.company.library.util;

import com.company.library.dto.ResponseDto;

public interface SimpleCrud<K, Rq, Rs> {
    ResponseDto<Rs> createEntity(Rq entity);

    ResponseDto<Rs> getEntity(K entityId);

    ResponseDto<Rs> updateEntity(K entityId, Rq entity);

    ResponseDto<Rs> deleteEntity(K entityId);

}
