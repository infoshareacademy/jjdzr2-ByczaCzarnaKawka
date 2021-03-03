package entities;

import domain.users.Gender;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String mailAddress;

    private String password;

    private int bornYear;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private AddressEntity addressEntity;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<DisciplineWithLevelEntity> disciplinesWithLevels;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getMailAddress() {
        return mailAddress;
    }

    void setMailAddress(final String mailAddress) {
        this.mailAddress = mailAddress;
    }

    String getPassword() {
        return password;
    }

    void setPassword(final String password) {
        this.password = password;
    }

    int getBornYear() {
        return bornYear;
    }

    void setBornYear(final int bornYear) {
        this.bornYear = bornYear;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Gender getGender() {
        return gender;
    }

    void setGender(final Gender gender) {
        this.gender = gender;
    }

    AddressEntity getAddressEntity() {
        return addressEntity;
    }

    void setAddressEntity(final AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    Set<DisciplineWithLevelEntity> getDisciplinesWithLevels() {
        return disciplinesWithLevels;
    }

    void setDisciplinesWithLevels(final Set<DisciplineWithLevelEntity> disciplinesWithLevels) {
        this.disciplinesWithLevels = disciplinesWithLevels;
    }
}
