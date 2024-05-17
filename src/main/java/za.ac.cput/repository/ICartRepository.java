package za.ac.cput.repository;
/**
 * E-Commerce Web Application for selling clothes
 * ICartRepository.java
 * This class provides the interface for the Cart entity
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 16 May 2024
 * */
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface ICartRepository extends IRepository<Cart, String> {
    List<Cart> getall();
}
