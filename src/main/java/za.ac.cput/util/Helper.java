package za.ac.cput.util;
/*
 *Product:java
 *Product: Helper Class
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import za.ac.cput.domain.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public  static String generateId(){
        return UUID.randomUUID().toString();
    }


    public static boolean isNullOrEmpty(LocalDateTime orderItems) {
        if(orderItems == null || orderItems.isEqual(null))
            return true;
        return false;

    }

    public static boolean isOrderNullorEmpty(Double s) {
        if (s == null || Double.isNaN(s))
            return true;
        return false;
    }

    public static boolean isNullOrEmpty(List<Order> s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }
}