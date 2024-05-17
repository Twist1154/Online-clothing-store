package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {
    @Test
    void buildUser() {
        User user = UserFactory.buildUser("I7I775", "Nicole", "fgfg","fgfbmg","gbhghhy","bhtyhjyt");
        assertNotNull(user);
        System.out.println(user);
    }

}