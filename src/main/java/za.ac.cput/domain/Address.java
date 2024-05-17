package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    private String AddressID;
    private String Street;
    private String city;
    private String province;
    private String zipCode;

    protected Address() {
    }

    private Address(Builder builder) {
        this.AddressID = builder.AddressID;
        this.Street = builder.Street;
        this.city = builder.city;
        this.province = builder.province;
        this.zipCode = builder.zipCode;

    }

    public String getAddressID() {
        return AddressID;
    }

    public String getStreet() {
        return Street;
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

    @Override
    public String toString() {
        return "Address{" +
                "AddressID=" + AddressID +
                ", Street='" + Street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public static class Builder{
        private String AddressID;
        private String Street;
        private String city;
        private String province;
        private String zipCode;

        public Builder setAddressID(String AddressID) {
            AddressID = AddressID;
            return this;
        }

        public Builder setStreet(String street) {
            Street = street;
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

        public Builder copy(Address address){
            this.AddressID = address.AddressID;
            this.Street = address.Street;
            this.city = address.city;
            this.province = address.province;
            this.zipCode = address.zipCode;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

}
