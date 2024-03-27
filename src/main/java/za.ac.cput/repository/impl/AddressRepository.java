package za.ac.cput.repository.impl;

import za.ac.cput.domain.Address;
import za.ac.cput.repository.IAddressRepository;


import java.util.ArrayList;
import java.util.List;

public class AddressRepository implements IAddressRepository {
    private static IAddressRepository repository = null;

    private List<Address> addressList;

    private AddressRepository(){
        addressList = new ArrayList<Address>();
    }

    public static IAddressRepository getRepository(){
        if(repository == null){
            repository = new AddressRepository();
        }
        return repository;
    }

    public Address create(Address address) {
        boolean success = addressList.add(address);
        if(success)
            return  address;
        return null;
    }

    public Address read(String id) {
        for(Address p: addressList){
            if(p.getAddressID().equals(id))
                return p;
        }
        return null;
    }

    public Address update(Address address) {
        String productID = address.getAddressID();
        if(delete(productID)){
            if(addressList.add(address))
                return address;
            else
                return null;
        }
        return null;
    }

    public boolean delete(String id) {
        Address addressToDelete = read(id);

        if(addressToDelete == null)
            return  false;

        return (addressList.remove(addressToDelete));
    }

    public List<Address> getAll() {
        return null;
    }
}

