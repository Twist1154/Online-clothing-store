package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserService extends IService<User, String>{

    /**
     * Finds users by their email address.
     *
     * @param email the email address to search for
     * @return a list of users with the given email
     */
    List<User> findByEmail(String email);

    List<User> findByLastName(String lastName);
}
