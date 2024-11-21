package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Address;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Person;

import java.util.List;

public class AddressAppHelper implements AppHelper<Address> {

    private final Input input;
    private final Service<Person> personService;

    public AddressAppHelper(Input input, Service<Person> personService) {
        this.input = input;
        this.personService = personService;
    }

    @Override
    public Address create() {
        Address address = new Address();
        try {
            System.out.print("Book title: ");
            address.setTitle(input.nextLine());
            personService.printList();
            System.out.print("Add author to list? (y/n): ");
            String addAuthorChoose = input.nextLine();
            if(addAuthorChoose.equals("y")){
                System.out.println("Exiting task...");
                return null;
            }
            System.out.print("Amount of authors in address: ");
            int countBookAuthors = Integer.parseInt(input.nextLine());
            for (int i = 0; i < countBookAuthors; i++){
                System.out.printf("Choose author number (%d author out of %d%n): ", i+1,countBookAuthors);
                int numberAuthor = Integer.parseInt(input.nextLine());
                address.getAuthors().add(authorService.list().get(numberAuthor-1));
            }
            System.out.print("Year of publishing: ");
            address.setPublishedYear(Integer.parseInt(input.nextLine()));
            return address;

        }catch (Exception e){
            return null;
        }
    }




    @Override
    public boolean printList(List<Book> books) {
        try {
            if(books.size() == 0) return false;
            for(int i = 0; i < books.size(); i++){
                StringBuilder sbAuthors = new StringBuilder();
                for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                    sbAuthors.append(books.get(i).getAuthors().get(j).getFirstname());
                    sbAuthors.append(" ");
                    sbAuthors.append(books.get(i).getAuthors().get(j).getLastname());
                    sbAuthors.append(". ");
                }
                System.out.printf("%d. %s. %s%d%n", i+1,books.get(i).getTitle(),sbAuthors.toString(),books.get(i).getPublishedYear());
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }
}
