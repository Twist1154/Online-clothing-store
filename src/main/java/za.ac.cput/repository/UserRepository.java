package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, String> {
    //User findUserbyUserId(String userID);

  //  void deleteUserByUserID(String userID);



}
