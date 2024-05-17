package za.ac.cput.repository;
/**
 * E-Commerce Web Application for selling clothes
 * ICartItemRepository.java
 * This class provides the interface for the CartItem entity
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 16 May 2024
 * */
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;

import java.util.List;

public interface ICartItemRepository extends IRepository<CartItem, String>{
    List<CartItem> getall();
}
