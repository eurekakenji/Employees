package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import models.Employee;

public class App {
    private Input input;
    private Service<Employee> employeeService;

    public App(Input input){
        this.input = input;
    }
    public void run(){
        boolean repeat = true;
        System.out.println("======= Employee =========");
        do {
            System.out.println("List of tasks:");
            System.out.println("0. Exit program");
            System.out.println("1. Add employee");
            System.out.println("2. List of employees");
            System.out.println("3. Edit employee");
            System.out.println("4. Search for employee by date of birth");
            System.out.print("Enter number from list: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    System.out.println("Exiting program...");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("Adding user...");
                    if(employeeService.add()){
                        System.out.println("User added");
                    }else{
                        System.out.println("Was unable to add user");
                    };
                    break;
                case 2:
                    if(employeeService.print()){
                        System.out.println("----------- End of list -----------");
                    }
                    break;
                case 3:
                    System.out.println("Editing employee...");
                    if(employeeService.edit()){
                        System.out.println("Employee edited");
                    }else {
                        System.out.println("Was unable to edit employee");
                    }
                    break;

                // case 4:
                 //   if(employeeService.print()){
                  //      System.out.println("----------- End of list -----------");
                  //  }
                  //  break;
                default:
                    System.out.println("Enter a valid task!");
                    break;
            }
            System.out.println("==============================");
        } while (repeat);
        System.out.println("Goodbye! :3");

    }
}
