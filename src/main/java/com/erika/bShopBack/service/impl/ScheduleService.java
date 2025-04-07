package com.erika.bShopBack.service.impl;

import com.erika.bShopBack.entity.ScheduleEntity;
import com.erika.bShopBack.service.iScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.erika.bShopBack.service.query.IScheduleQueryService;

@Service
@AllArgsConstructor
public class ScheduleService implements iScheduleService {

    private final iScheduleService repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.delete(id);
    }
}
