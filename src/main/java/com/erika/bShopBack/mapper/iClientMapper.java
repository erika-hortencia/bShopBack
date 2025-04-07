package com.erika.bShopBack.mapper;

import com.erika.bShopBack.controller.request.SaveClientRequest;
import com.erika.bShopBack.controller.request.UpdateClientRequest;
import com.erika.bShopBack.controller.response.ClientDetailResponse;
import com.erika.bShopBack.controller.response.ListClientResponse;
import com.erika.bShopBack.controller.response.SaveClientResponse;
import com.erika.bShopBack.controller.response.UpdateClientResponse;
import com.erika.bShopBack.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface iClientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);
}
