package ee.ivkhkdev.apphelpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Person;

import java.util.List;

public class PersonAppHelper implements AppHelper<Person> {
    private final Input input;


    public PersonAppHelper(Input input) {
        this.input = input;

    }

    @Override
    public Person create() {
        try {
            Person person = new Person();
            System.out.print("Person name: ");
            person.setFirstName(input.nextLine());
            System.out.print("Person Surname: ");
            person.setLastName(input.nextLine());
            System.out.print("Person Phone Number: ");
            person.setPhone(input.nextLine());
            System.out.print("Person Birth Date: ");
            person.setBirthdate(java.time.LocalDate.parse(input.nextLine()));
            System.out.print("Person Gender: ");
            person.setGender(input.nextLine());
            System.out.print("Person bank: ");
            person.setBank(input.nextLine());
            return person;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean printList(List<Person>people) {
        try {
            if(people.size() == 0) return false;
            for(int i = 0; i < people.size(); i++){
                System.out.printf("%d. %s %s. %s%n",
                        i+1,
                        people.get(i).getFirstName(),
                        people.get(i).getLastName(),
                        people.get(i).getPhone()
                );
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }
}
