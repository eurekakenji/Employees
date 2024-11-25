package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Repository;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Address;

import java.util.List;

public class AddressService implements Service<Address> {
    private final AppHelper<Address> helper;
    private final Repository<Address> repository;

    public AddressService(AppHelper<Address> helper, Repository<Address> repository) {
        this.helper = helper;
        this.repository = repository;
    }

    @Override
    public boolean add() {
        Address address = helper.create();
        if (address != null) {
            repository.save(address);
            return true;
        }
        System.out.println("Failed to create address.");
        return false;
    }

    @Override
    public boolean edit() {
        List<Address> addresses = repository.load();
        if (addresses.isEmpty()) {
            System.out.println("No addresses available to edit.");
            return false;
        }

        boolean isEdited = helper.edit(addresses) != null;
        if (isEdited) {
            repository.saveAll(addresses);
            return true;
        }
        System.out.println("Failed to edit addresses.");
        return false;
    }

    @Override
    public boolean print() {
        List<Address> addresses = repository.load();
        if (addresses.isEmpty()) {
            System.out.println("No addresses to display.");
            return false;
        }

        return helper.printList(addresses);
    }

    @Override
    public List<Address> list() {
        return repository.load();
    }

    @Override
    public void printList() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Address get(Address j) {
        return null;
    }
}

