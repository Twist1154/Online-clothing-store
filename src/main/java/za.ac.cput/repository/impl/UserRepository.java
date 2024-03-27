package za.ac.cput.repository.impl;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IAdminRepository;
import za.ac.cput.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository implements IUserRepository {
    private static IUserRepository repository = null;
    private List<User> userList;

    private UserRepository(){
        userList = new ArrayList<User >();
    }

    public static IUserRepository getRepository(){
        if (repository == null){
            repository = new UserRepository();
        }
        return repository;
    }

    public User create (User user ){
        boolean success = userList.add(user);
        if (success){
            return user;
        }
        return null;

    }

    @Override
    public User read(String s) {
        for (User a : userList) {
            if (Objects.equals(a.getUserID(), s))
                return a;
        }
        return null;
    }


    @Override
    public User update(User user) {
        String id = user.getUserID();
        User userOld = read(id);
        if (userOld == null)
            return null;
        boolean success = delete(id);
        if (success){
            if (userList.add(user))
                return user;
        }
        return null;
    }
    @Override
    public boolean delete(String s) {
        User userToDelete = read(s);
        if (userToDelete == null)
            return false;
        return (userList.remove(userToDelete));
    }

    @Override
    public List<User> getall() {
        return userList;}



}
