package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    void buildAddress() {
        Address address = AddressFactory.buildAddress("CPT55","Door","CapeTown","WesternCapa","3344");

        assertNotNull(address);
        System.out.println(address);
    }
}