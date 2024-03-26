package za.ac.cput.repository;
import za.ac.cput.domain.Admin;
import java.util.List;

/*
 *User:java
 *User: Model Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 27 March 2024
 */

public interface IAdminRepository extends IRepository<Admin, String>{
    List<Admin> getall();
}
