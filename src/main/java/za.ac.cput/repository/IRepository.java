package za.ac.cput.repository;
/*
 *Product:java
 *Product: Repository Interface
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import za.ac.cput.domain.Customer;

public interface IRepository<T, ID> {
    T create(T t);

    Customer read(String  id);

    T update(T t);

    boolean delete(ID id);
}