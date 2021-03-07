package entity;

import domain.users.Gender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    private String nickname;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(referencedColumnName = "sportDiscipline")
    private List<DisciplinesEntity> disciplines;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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

    public List<DisciplinesEntity> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(final List<DisciplinesEntity> disciplines) {
        this.disciplines = disciplines;
    }
}
