package za.ac.cput.util;
/*
 *Product:java
 *Product: Helper Class
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import za.ac.cput.domain.Order;
import za.ac.cput.domain.User;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }


    public static boolean isOrderNullorEmpty(Double s) {
        return s == null || Double.isNaN(s);
    }

    public static boolean isNullOrEmpty(List<Order> s) {
        return s == null || s.isEmpty();
    }

    public static boolean isEmailValid(String emailAddress) {
        String regexemail ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \n" +
                "        + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexemail)
                .matcher(emailAddress)
                .matches();
    }

}