package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory    {
    public static Address buildAddress(String AddressID, String Street,String city,
                                     String province,String zipCode){
        if (Helper.isNullOrEmpty(AddressID) || Helper.isNullOrEmpty(Street))
            return null;

        return new Address.Builder().setAddressID(AddressID).setStreet(Street)
                .setCity(city).setProvince(province).setZipCode(zipCode)
                .build();
    }
}
