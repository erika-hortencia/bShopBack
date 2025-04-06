package com.erika.bShopBack.service;

import  com.erika.bShopBack.entity.ClientEntity;

public interface iClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);
}
