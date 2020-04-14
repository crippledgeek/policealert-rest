package se.disabledsecurity.policealert.rest.mapper;


import se.disabledsecurity.policealert.rest.domain.Alert;
import se.disabledsecurity.policealert.rest.domain.EventType;
import se.disabledsecurity.policealert.rest.entity.AlertEntity;

public class AlertMapper {
    public static Alert map(AlertEntity entity) {
        return Alert.builder()
                .id(entity.getExternalId())
                .datetime(entity.getDatetime())
                .summary(entity.getSummary())
                .name(entity.getName())
                .url(entity.getUrl())
                .type(EventType.valueOf(entity.getType().name()))
                .location(LocationMapper.map(entity))
                .build();

    }
}
