package se.disabledsecurity.policealert.rest.service;

import se.disabledsecurity.policealert.rest.domain.Alert;

import java.util.List;

public interface AlertService {
    List<Alert> findAll();

    Alert findById(final Long id);

    List<Alert> findByEventType(final String eventType);

}
