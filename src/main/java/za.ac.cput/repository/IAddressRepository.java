package za.ac.cput.repository;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Product;

import java.util.List;

public interface IAddressRepository extends IRepository<Address, String> {
    List<Address> getAll();
}
