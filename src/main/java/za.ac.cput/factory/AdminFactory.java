package za.ac.cput.factory;
import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

/*
 *AdminFactory:java
 *Admin: Factory Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
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
