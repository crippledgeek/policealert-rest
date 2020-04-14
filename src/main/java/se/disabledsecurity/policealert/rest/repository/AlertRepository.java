package se.disabledsecurity.policealert.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.disabledsecurity.policealert.rest.entity.AlertEntity;

@Repository
public interface AlertRepository extends CrudRepository<AlertEntity, Long> {

}
