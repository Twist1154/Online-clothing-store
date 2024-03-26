package za.ac.cput.factory;
import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public class AdminFactory {
    public static Admin buildAdmin(String adminID, String privileges){
        if (Helper.isNullOrEmpty(adminID) || Helper.isNullOrEmpty(privileges))
            return null;

        return new Admin.Builder().setAdminId(adminID)
                .setPrivileges(privileges)
                .build();
    }
}
