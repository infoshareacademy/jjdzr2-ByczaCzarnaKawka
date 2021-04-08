package com.infoshare.service.entity;

import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.entity.id.SportFacilityID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "sport_facility")
@IdClass(SportFacilityID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportFacilityEntity {

    @Id
    private String facilityName;

    @Id
    @Enumerated(EnumType.STRING)
    private SportDiscipline sportDiscipline;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "address_id")
    private AddressEntity addressEntity;

    private LocalTime openHour;

    private LocalTime closeHour;

    private BigDecimal price;

}
