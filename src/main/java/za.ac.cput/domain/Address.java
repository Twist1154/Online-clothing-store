package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
    @Id
    private String addressID;
    private String street;
    private String city;
    private String province;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user;

    protected Address() {
    }

    private Address(Builder builder) {
        this.addressID = builder.addressID;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;
    }

    public String getAddressID() {
        return addressID;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;

        if (getAddressID() != null ? !getAddressID().equals(address.getAddressID()) : address.getAddressID() != null)
            return false;
        if (getStreet() != null ? !getStreet().equals(address.getStreet()) : address.getStreet() != null) return false;
        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        if (getProvince() != null ? !getProvince().equals(address.getProvince()) : address.getProvince() != null)
            return false;
        if (getZipCode() != null ? !getZipCode().equals(address.getZipCode()) : address.getZipCode() != null)
            return false;
        return getUser() != null ? getUser().equals(address.getUser()) : address.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getAddressID() != null ? getAddressID().hashCode() : 0;
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getProvince() != null ? getProvince().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID='" + addressID + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public static class Builder {
        private String addressID;
        private String street;
        private String city;
        private String province;
        private String zipCode;

        public Builder setAddressID(String addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder copy(Address address) {
            this.addressID = address.addressID;
            this.street = address.street;
            this.city = address.city;
            this.province = address.province;
            this.zipCode = address.zipCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
