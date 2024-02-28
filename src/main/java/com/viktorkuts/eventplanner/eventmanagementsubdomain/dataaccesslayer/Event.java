package com.viktorkuts.eventplanner.eventmanagementsubdomain.dataaccesslayer;

import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.Performer;
import com.viktorkuts.eventplanner.usersubdomain.dataaccesslayer.PerformerIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "events")
@NoArgsConstructor
@Embeddable
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EventIdentifier eventIdentifier;

    @Column(name = "eventname")
    private String eventName;

    @Column(name = "startsat")
    private Date startsAt;

    @Column(name = "endsat")
    private Date endsAt;

    @Column(name = "eventtype")
    @Enumerated(EnumType.STRING)
    private EventType eventType;


//    @ManyToOne
//    @JoinColumn(name = "performerid")
//    private Performer performer;
}
