package se.disabledsecurity.policealert.rest.mapper;

import se.disabledsecurity.policealert.rest.domain.Location;
import se.disabledsecurity.policealert.rest.entity.AlertEntity;

public class LocationMapper {
    public static Location map (AlertEntity entity) {
       return Location.builder()
                .gps(entity.getLocation().getLocationPK().getGps())
                .locationName(entity.getLocation().getLocationPK().getName())
                .build();

    }
}
