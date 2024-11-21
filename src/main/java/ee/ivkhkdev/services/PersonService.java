package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Repository;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Person;

import java.util.List;

public class PersonService implements Service<Person> {
    private final Repository<Person> repository;
    private AppHelper<Person> appHelperPerson;

    public PersonService(AppHelper<Person> appHelperPerson, Repository<Person> repository) {
        this.appHelperPerson = appHelperPerson;
        this.repository = repository;
    }

    public boolean add() {
        Person person = appHelperPerson.create();
        if(person == null ) return false;
        try {
            repository.save(person);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean edit() {
        List<Person> modifiedUsers = appHelperPerson.edit(repository.load());
        if(modifiedUsers == null || modifiedUsers.size() == 0){
            return false;
        }
        repository.saveAll(modifiedUsers);
        return true;
    }

    public boolean print() {
        return appHelperPerson.printList(repository.load());
    }

    @Override
    public List list() {
        return repository.load();
    }
}
