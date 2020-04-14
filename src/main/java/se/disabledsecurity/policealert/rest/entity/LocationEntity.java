package se.disabledsecurity.policealert.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.CompareToBuilder;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Location")
@Entity
public class LocationEntity implements Comparable<LocationEntity> {

    @EmbeddedId
    LocationPK locationPK;



    @OneToMany(cascade = CascadeType.ALL)
    private Set<AlertEntity> alerts = new HashSet<>();


    public void addAlert(AlertEntity alert) {
        alert.setLocation(this);
    }


    @Override
    public int compareTo(LocationEntity o) {
        return CompareToBuilder.reflectionCompare(this, o);
    }
}
