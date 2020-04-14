package se.disabledsecurity.policealert.rest.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@EqualsAndHashCode
@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    private Long id;
    private String name;
    private String summary;
    private String url;
    private Location location;
    private EventType type;
    private ZonedDateTime datetime;
}
