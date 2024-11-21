package ee.ivkhkdev.config;

import ee.ivkhkdev.App;
import ee.ivkhkdev.apphelpers.AddressAppHelper;
import ee.ivkhkdev.apphelpers.PersonAppHelper;
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.interfaces.Repository;
import ee.ivkhkdev.model.Person;
import ee.ivkhkdev.services.AddressService;
import ee.ivkhkdev.services.EmployeeService;
import ee.ivkhkdev.services.PersonService;
import ee.ivkhkdev.storage.Storage;
import ee.ivkhkdev.interfaces.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Scanner;

@Configuration
public class AppConfiguration {

    @Bean
    public Input input() {
        return new ConsoleInput(new Scanner(System.in));
    }
    @Bean
    public Repository<Employee> employeeRepository() {
        return new Storage<>("employees");
    }
    @Bean
    public Repository<Address> addressRepository() {
        return new Storage<>("addresses");
    }
    @Bean
    public Repository<Person> personRepository() {
        return new Storage<>("people");
    }
    @Bean
    public AppHelper<Address> addressAppHelper(Input input){
        return new AddressAppHelper(input);
    }
    @Bean
    public AppHelper<Person> personAppHelper(Input input){
        return new PersonAppHelper(input);
    }

    @Bean
    public Service<Address> addressService(AppHelper<Address> addressAppHelper, Repository<Address> addressRepository){
        return new AddressService<>(addressAppHelper, addressRepository);
    }
    @Bean
    public AppHelper<Person> personAppHelper(Input input, Service<Person> personService){
        return new PersonAppHelper(input,personService);
    }
    @Bean
    public Service<Person> personService(AppHelper<Person> personAppHelper,Repository<Person> personRepository){
        return new PersonService<>(personAppHelper, personRepository);
    }
    @Bean
    public Service<Employee> employeeService(AppHelper<Employee> employeeAppHelper,Repository<Employee> employeeRepository){
        return new EmployeeService<>(employeeAppHelper, employeeRepository);
    }
    @Bean
    public App app(Input input,Service<Employee> employeeService,Service<Person> personService,Service<Address> addressService){
        return new App(input, employeeService, personService, addressService);
    }


}