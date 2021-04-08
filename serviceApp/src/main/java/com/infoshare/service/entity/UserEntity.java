package com.infoshare.service.entity;

import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.users.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID id;

    private String nickname;

    @Column(unique = true)
    private String mailAddress;

    private String password;

    private int bornYear;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "address_id")
    private AddressEntity addressEntity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Map<SportDiscipline, SportWithLevelEntity> disciplines;

    public UserEntity(final String nickname, final String mailAddress, final String password, final int bornYear,
                final String phoneNumber, final Gender gender, final AddressEntity addressEntity, final Map<SportDiscipline, SportWithLevelEntity> disciplines) {
        this.nickname = nickname;
        this.mailAddress = mailAddress;
        this.password = password;
        this.bornYear = bornYear;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.addressEntity = addressEntity;
        this.disciplines = disciplines;
    }
}
