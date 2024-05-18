package za.ac.cput.service;
/*
 *Product:java
 *Product: Service interface Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import java.util.List;
public interface IService<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    List<T> getAll();
}
