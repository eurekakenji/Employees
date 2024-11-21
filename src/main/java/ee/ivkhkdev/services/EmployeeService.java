package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Repository;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Employee;

import java.util.List;

public class EmployeeService implements Service<Employee> {
    private Repository<Employee> repository;
    private AppHelper<Employee> appHelperEmployee;

    public EmployeeService(AppHelper<Employee> appHelperEmployee, Repository<Employee> repository) {
        this.appHelperEmployee = appHelperEmployee;
        this.repository = repository;
    }

    public AppHelper<Employee> getAppHelperEmployee() {
        return appHelperEmployee;
    }

    public boolean add(){
        Employee employee = appHelperEmployee.create();
        if(employee == null) return false;
        try {
            repository.save(employee);
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean print() {
        return appHelperEmployee.printList(repository.load());
    }

    @Override
    public List<Employee> list() {
        return repository.load();
    }
}
