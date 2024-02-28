package com.viktorkuts.eventplanner.venuemanagement.dataaccesslayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private VenueIdentifier venueIdentifier;

    @Embedded
    private VenueAddress location;

    @Column(name = "venuename")
    private String venueName;
}
