package com.infoshare.service.entity;

import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.entity.id.SportWithLevelID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sport_with_activity_level")
@IdClass(SportWithLevelID.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportWithLevelEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private SportDiscipline sportDiscipline;

    @Id
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

}
