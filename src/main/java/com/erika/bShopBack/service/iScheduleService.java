package com.erika.bShopBack.service;

import com.erika.bShopBack.entity.ScheduleEntity;

public interface iScheduleService {
    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);
}
