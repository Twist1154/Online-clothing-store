package za.ac.cput.util;
/*
 *Product:java
 *Product: Helper Class
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import za.ac.cput.domain.Order;

import java.util.List;
import java.util.UUID;

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

    public static boolean isValidRange(int rating) {
        return rating > 0 && rating <= 5;
    }
}