package ee.ivkhkdev.apphelpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Employee;

import java.util.List;

public class EmployeeAppHelper implements AppHelper<Employee>{
    private final Input input;

    public EmployeeAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public Employee create() {
        Employee employee = new Employee();
        try {
            System.out.print("Name: ");
            employee.setFirstname(input.nextLine());
            System.out.print("Surname: ");
            employee.setLastname(input.nextLine());
            return employee;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean printList(List<Employee> employees) {
        try {
            if(employees.size() < 1) return false;
            for(int i = 0; i < employees.size(); i++){
                System.out.printf("%d. %s %s%n", i+1,employees.get(i).getFirstname(),employees.get(i).getLastname());
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
