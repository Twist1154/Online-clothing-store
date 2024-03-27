package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.repository.IAdminRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminRepositoryTest {
    private static IAdminRepository repository = AdminRepository.getRepository();
    private Admin admin = AdminFactory.buildAdmin("30011467", "Happiness");

    @Test
    @Order(1)
    void create(){
        Admin created = repository.create(admin);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read(){
        Admin read = repository.read(admin.getAdminId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update(){
        Admin newAdmin = new Admin.Builder().copy(admin).setPrivileges("Sadness").build();
        Admin updated = repository.update(newAdmin);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete(){
        assertTrue(repository.delete(admin.getAdminId()));
        System.out.println("Success: admin deleted");
    }

    @Test
    @Order(4)
    void getall(){
        System.out.println(repository.getall());
    }
}