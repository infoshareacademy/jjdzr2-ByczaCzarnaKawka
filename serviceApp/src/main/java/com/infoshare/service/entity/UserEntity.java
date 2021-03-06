package com.infoshare.service.entity;

import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.users.Gender;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
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

    public UserEntity(String nickname, String mailAddress, String password, int bornYear, String phoneNumber, Gender gender, AddressEntity addressEntity, Map<SportDiscipline, SportWithLevelEntity> disciplines) {
        this.nickname = nickname;
        this.mailAddress = mailAddress;
        this.password = password;
        this.bornYear = bornYear;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.addressEntity = addressEntity;
        this.disciplines = disciplines;
    }

    public UserEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(final String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(final int bornYear) {
        this.bornYear = bornYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(final AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Map<SportDiscipline, SportWithLevelEntity> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(final Map<SportDiscipline, SportWithLevelEntity> disciplines) {
        this.disciplines = disciplines;
    }
}
