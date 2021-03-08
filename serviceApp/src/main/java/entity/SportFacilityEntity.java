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
    @Column(name = "facility_name")
    private String facilityName;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sport_discipline")
    private SportDisciplineEntity sportDiscipline;

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

    public SportDisciplineEntity getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(final SportDisciplineEntity sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    AddressEntity getAddressEntity() {
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
