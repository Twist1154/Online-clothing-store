package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/*
 *Product:java
 *Product: ProductImageFactoryTest Class
 * Author: Zachariah Matsimella
 * Date: 26 March 2024
 */
public class ProductImageFactoryTest {

    @BeforeEach
    void setUp(){

    }

    @Test
    @Disabled
    @Timeout(200)
    public void disabled(){
        System.out.println("This test should be disabled. If not then a timout should occur in 2 seconds.");
    }

    @Test
    @Timeout(5)
    public void timeout() throws InterruptedException{
        Thread.sleep(2000);
    }
}
