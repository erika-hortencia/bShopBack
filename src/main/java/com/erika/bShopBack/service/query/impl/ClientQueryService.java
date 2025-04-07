package com.erika.bShopBack.service.query.impl;

import com.erika.bShopBack.exception.NotFoundException;
import com.erika.bShopBack.exception.PhoneInUseException;
import com.erika.bShopBack.service.query.IClientQueryService;
import com.erika.bShopBack.entity.ClientEntity;
import com.erika.bShopBack.exception.EmailInUseException;
import com.erika.bShopBack.exception.ScheduleInUseException;
import com.erika.bShopBack.repository.iClientRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ClientQueryService implements IClientQueryService {

    private final iClientRepository repository;

    @Override
    public ClientEntity findById(final long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Cliente" + id + "not found")
        );
    }

    @Override
    public List<ClientEntity> list() {
        return repository.findAll();
    }

    @Override
    public void verifyPhone(final String phone) {
        if (repository.existsByPhone(phone)) {
            var message = "Phone number " + phone + " is already in use";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyPhone(final long id, final String phone) {
        var optional = repository.findByPhone(phone);
        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), phone)) {
            var message = "Phone number " + phone + " is already in use";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyEmail(final String email) {
        if (repository.existsByEmail(email)) {
            var message = "e-mail " + email + " is already in use";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyEmail(final long id, final String email) {
        var optional = repository.findByEmail(email);
        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), email)) {
            var message = "e-mail " + email + " is already in use";
            throw new PhoneInUseException(message);
        }
    }
}
