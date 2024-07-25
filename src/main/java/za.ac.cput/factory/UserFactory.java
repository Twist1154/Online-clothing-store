package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
    public static User buildingUser(String userID, String firstName, String lastName,
                                 String password, String email, String addressID, String customerID) {
        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)
                ||  addressID == null)
            return null;
    
        String regex = "^(.+)@(\\S+)$";
        if (!Helper.isEmailValid(email, regex) || Helper.isNullOrEmpty(email)) return null;

        return new User.Builder().setUserID(userID).setFirstName(firstName).setLastName(lastName)
                .setEmail(email).setPassword(password).setAddressID(addressID).setCustomerID(customerID)
                .build();
}
}
