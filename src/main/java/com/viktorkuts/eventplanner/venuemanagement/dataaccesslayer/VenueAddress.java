package com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;

@Embeddable
@Data
public class VenueAddress {
    @Column(name = "unit")
    private Integer unitNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;
}
