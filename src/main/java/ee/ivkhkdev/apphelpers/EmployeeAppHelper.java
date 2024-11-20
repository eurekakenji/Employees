package ee.ivkhkdev.apphelpers;

import ee.ivkhkdev.interfaces.Input;
import models.Employee;

import java.util.List;

public class EmployeeAppHelper {
    private final Input input;

    public EmployeeAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public Employee create() {
        Employee employee = new Employee();
        try {
            System.out.print("Имя: ");
            employee.setFirstname(input.nextLine());
            System.out.print("Фамилия: ");
            employee.setLastname(input.nextLine());
            return employee;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean printList(List<Author> authors) {
        try {
            if(authors.size() < 1) return false;
            for(int i = 0; i < authors.size(); i++){
                System.out.printf("%d. %s %s%n", i+1,authors.get(i).getFirstname(),authors.get(i).getLastname());
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }

    @Override
    public List<Employee> edit(List<Employee> employees) {
        return List.of();
    }
}
