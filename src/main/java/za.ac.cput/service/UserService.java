package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {
    private AddressRepository addressrepository;
    private UserRepository repository;
    @Autowired

    public UserService(AddressRepository addressrepository, UserRepository repository) {
        this.addressrepository = addressrepository;
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(String s) {
        return repository.findUserbyUserId(s);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
