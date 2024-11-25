package ee.ivkhkdev.helpers;


import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.model.Person;

import java.util.List;

public class AddressAppHelper implements AppHelper<Address> {

    private final Input input;
    private final Service<Person> personService;

    public AddressAppHelper(Input input, Service<Person> personService) {
        this.input = input;
        this.personService = this.personService;
    }

    @Override
    public Address create() {
        Address address = new Address();
        try {
            System.out.print("Address title: ");
            address.setTitle(input.nextLine());
            personService.printList();
            System.out.print("Add person to authors list? (y/n): ");
            String addAuthorChoose = input.nextLine();
            if (addAuthorChoose.equals("y")) {
                System.out.println("Exiting task...");
                return null;
            }
            System.out.print("Amount of authors in address: ");
            int countBookAuthors = Integer.parseInt(input.nextLine());
            for (int i = 0; i < countBookAuthors; i++) {
                System.out.printf("Choose person number (%d person out of %d)%n: ", i + 1, countBookAuthors);
                int numberAuthor = Integer.parseInt(input.nextLine());
                address.getAuthors().add(personService.list().get(numberAuthor - 1));
            }
            System.out.print("Year of publishing: ");
            address.setPublishedYear(Integer.parseInt(input.nextLine()));
            return address;

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    @Override
    public boolean printList(List<Address> addresses) {
        try {
            if (addresses.size() == 0) return false;
            for (int i = 0; i < addresses.size(); i++) {
                StringBuilder sbAuthors = new StringBuilder();
                for (int j = 0; j < addresses.get(i).getAuthors().size(); j++) {
                    sbAuthors.append(addresses.get(i).getAuthors().get(j).getClass());
                    sbAuthors.append(" ");
                    sbAuthors.append(addresses.get(i).getAuthors().get(j).getClass());
                    sbAuthors.append(". ");
                }
                System.out.printf("%d. %s. %s%d%n",
                        i + 1,
                        addresses.get(i).getTitle(),
                        sbAuthors.toString(),
                        addresses.get(i).getPublishedYear()
                );
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }
}

