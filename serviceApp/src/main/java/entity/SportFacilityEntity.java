package entity;

import entity.id.SportFacilityID;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "sport_facility")
@IdClass(SportFacilityID.class)
public class SportFacilityEntity {

    @Id
    private String facilityName;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private SportDisciplineEntity sportDisciplineEntity;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "address_id")
    private AddressEntity addressEntity;

    private LocalTime openHour;

    private LocalTime closeHour;

    private BigDecimal price;

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(final String facilityName) {
        this.facilityName = facilityName;
    }

    public SportDisciplineEntity getSportDisciplineEntity() {
        return sportDisciplineEntity;
    }

    public void setSportDisciplineEntity(final SportDisciplineEntity sportDisciplineEntity) {
        this.sportDisciplineEntity = sportDisciplineEntity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(final AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public void setOpenHour(final LocalTime openHour) {
        this.openHour = openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(final LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }
}
