package za.ac.cput.repository.impl;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.IAdminRepository;
import java.util.ArrayList;
import java.util.List;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public class AdminRepository implements IAdminRepository {
    private static IAdminRepository repository = null;
    private List<Admin> adminList;

    private AdminRepository() {
        adminList = new ArrayList<Admin>();
    }

    public static IAdminRepository getRepository(){
        if (repository == null){
            repository = new AdminRepository();
        }
        return repository;
    }


    @Override
    public Admin create(Admin admin) {
        boolean success = adminList.add(admin);
        if (success){
            return admin;
        }
        return null;
    }

    @Override
    public Admin read(String s) {
        for (Admin a : adminList){
            if (a.getAdminId().equals(s))
                return a;
        }
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        String id = admin.getAdminId();
        Admin adminOld = read(id);
        if (adminOld == null)
            return null;
        boolean success = delete(id);
        if (success){
            if (adminList.add(admin))
                return admin;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Admin adminToDelete = read(s);
        if (adminToDelete == null)
            return false;
        return (adminList.remove(adminToDelete));
    }

    @Override
    public List<Admin> getall() {
        return adminList;
    }
}
