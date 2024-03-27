package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void buildAdmin() {
        Admin admin = AdminFactory.buildAdmin("217061567", "Relaxed");

        assertNotNull(admin);
        System.out.println(admin);
    }
}