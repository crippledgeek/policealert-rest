package se.disabledsecurity.policealert.rest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import se.disabledsecurity.policealert.rest.domain.Alert;
import se.disabledsecurity.policealert.rest.mapper.AlertMapper;
import se.disabledsecurity.policealert.rest.repository.AlertRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class InternalAlertService implements AlertService {

    private AlertRepository repository;

    @Override
    public List<Alert> findAll() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(repository.findAll().iterator(),
                Spliterator.ORDERED),
                false)
                .map(AlertMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Alert findById(Long id) {
        return repository.findById(id)
                .map(AlertMapper::map)
                .orElseThrow(()->new NoSuchElementException("No alert with id: " + id + " found"));

    }

    @Override
    public List<Alert> findByEventType(String eventType) {
        return null;
    }
}
