package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="COUNTRY_SEARCH_HISTORY")
@Data
public class CountrySearchHistoryEntity extends PanacheEntity {


    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATED_ON")
    private String createdOn;


}
