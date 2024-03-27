package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface ICartRepository extends IRepository<Cart, String> {
    List<Cart> getall();
}
