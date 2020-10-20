package Operation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import Model.Person;

public class Operations {

    Scanner sc = new Scanner(System.in);
    Person person = new Person();
    ArrayList<Person> records = new ArrayList<Person>();
    int count;

    // To add a person's details
    public void addPerson() {
            System.out.println("*****ADD RECORDS*****");
            System.out.println("How many records you want to add?");
            int numOfRecods = sc.nextInt();
            count = 0;
            for (int i = 1; i <= numOfRecods; i++) {
                    System.out.println("Enter the First name");
                    String firstName = sc.next();
                    person.setFirstName(firstName);

                    System.out.println("Enter the Last name");
                    String lastName = sc.next();
                    person.setLastName(lastName);

                    System.out.println("Enter your Address");
                    String address = sc.next();
                    person.setAddress(address);

                    System.out.println("Enter your City");
                    String city = sc.next();
                    person.setCity(city);

                    System.out.println("Enter your State");
                    String state = sc.next();
                    person.setState(state);

                    System.out.println("Enter your Zip Code");
                    int zipcode = sc.nextInt();
                    person.setZip(zipcode);

                    System.out.println("Enter your Phone Number");
                    long phone = sc.nextLong();
                    person.setPhoneNo(phone);

                    records.add(new Person(person.getFirstName(), person.getLastName(), person.getAddress(), person.getCity(), person.getState(), person.getZip(), person.getPhoneNo()));
                    System.out.println(i + " records added successfully");
            }
            System.out.println("All records are added successfully\n");
    }

    // To update a person's details
    public void updatePerson() {
            System.out.println("****Update Record****");
            if (records.isEmpty() == false) {
                    System.out.println("Enter contact no.");
                    long contactSearch = sc.nextLong();
                    for (int i = 0; i < records.size(); i++) {
                            if (records.get(i) != null && records.get(i).getPhoneNo() == contactSearch) {
                                    System.out.println(records.get(i).getFirstName());
                                    System.out.println("Please select field you need to edit");
                                    System.out.println("1. Address");
                                    System.out.println("2. City");
                                    System.out.println("3. State");
                                    System.out.println("4. Zipcode");
                                    System.out.println("5. Phone Number");
                                    int choiceUpdate = sc.nextInt();
                                    switch (choiceUpdate) {
                                    case 1:
                                            System.out.println("Enter your Address");
                                            String addressUpdate = sc.next();
                                            records.get(i).setAddress(addressUpdate);
                                            System.out.println("Address Updated");
                                            break;
                                    case 2:
                                            System.out.println("Enter your City ");
                                            String cityUpdate = sc.next();
                                            records.get(i).setCity(cityUpdate);
                                            System.out.println("City Updated");
                                            break;
                                    case 3:
                                            System.out.println("Enter your State");
                                            String stateUpdate = sc.next();
                                            records.get(i).setState(stateUpdate);
                                            System.out.println("State Updated");
                                            break;
                                    case 4:
                                            System.out.println("Enter Your Zipcode");
                                            int zipcodeUpdate = sc.nextInt();
                                            records.get(i).setZip(zipcodeUpdate);
                                            System.out.println("Zipcode Updated");
                                            break;
                                    case 5:
                                            System.out.println("Enter Phone Number");
                                            long phoneUpdate = sc.nextLong();
                                            records.get(i).setPhoneNo(phoneUpdate);
                                            System.out.println("Phone Number Updated");
                                            break;
                                    default:
                                            System.out.println("Update Invalid choive! Enter again..\n");
                                            break;
                                    }
                            }
                    }
            }
            else {
                    System.out.println("Address book is Empty!");
            }
            System.out.println();
    }

    // To delete a person's details
    public void deletePerson() {
            System.out.println("*****Delete the record*****");
            if (records.isEmpty() == false) {
                    System.out.println("Enter phone number for deletion : ");
                    long PhoneDelete = sc.nextLong();
                    for (int i = 0; i < records.size(); i++) {
                            if (records.get(i) != null && records.get(i).getPhoneNo() == PhoneDelete) {
                                    records.remove(i);
                                    System.out.println("Record deleted successfully");
                                    break;
                            }
                    }
            }else {
                    System.out.println("Address book is Empty!");
            }

            System.out.println();
    }

    // To search a person's details
    public void searchPerson() {
            System.out.println("*****Search a person*****");
            if (records.isEmpty() == false) {
                    System.out.println("Enter Phone Number to search: ");
                    long PhoneSearch = sc.nextLong();
                    for (int i = 0; i < records.size(); i++) {
                            if (records.get(i) != null && records.get(i).getPhoneNo() == PhoneSearch) {

                                    System.out.println("Your record:\n"+records.get(i));
                            }
                    }
            }else {
                    System.out.println("Address book is Empty!");
            }

            System.out.println();
    }

    //To sort all records by Last name
    public void sortByLastName() {
    	class SortbyLastName implements Comparator<Person> 
    	{ 
    	
			@Override
			public int compare(Person a, Person b) {
				// TODO Auto-generated method stub
				return a.getLastName().compareTo(b.getLastName());
			} 
    	} 
    	Collections.sort(records, new SortbyLastName());
        System.out.println("***** Records Sorted by Last Name *****");
        /*Map<String, Person> map = new TreeMap<>();
        int i = 0;
        for (Person person : records) {
             String key = person.getLastName();
             if (map.containsKey(key)) {
                  key = key + "" + i;
                  i++;
             }
             map.put(key, person);
        }
        System.out.println("***** Records Sorted by Last Name *****");
        for (Person person : map.values()) {
            System.out.print(person+"\n");
       }*/
	}
    
    public void sortByZip() {
    	
    	class SortbyZipCode implements Comparator<Person> 
    	{ 
    	
			@Override
			public int compare(Person a, Person b) {
				// TODO Auto-generated method stub
				return a.getZip() - b.getZip();
			} 
    	} 
    	Collections.sort(records, new SortbyZipCode());
        System.out.println("***** Records Sorted by ZipCode *****");
    	
        /*Map<Integer, Person> map = new TreeMap<>();
        int i = 1;
        for (Person person : records) {
             int key = person.getZip();
             if (map.containsKey(key)) {
                  key = key + i;
                  i++;
             }
             map.put(key, person);
        }
        System.out.println("***** Records Sorted by ZipCode *****");
        for (Person person : map.values()) {
            System.out.print(person+"\n");
       }
        System.out.println();*/
	}
    
    
    // To display all the records
    public void displayRecords() {
            System.out.println("****Display Records****");
            if (records.isEmpty() == false) {
                    for (int i = 0; i < records.size(); i++) {
                            if (records.get(i) == null) {
                                    continue;
                            }
                            System.out.println(records.get(i));
                    }
            }else {
                    System.out.println("Address book is Empty!");
            }

            System.out.println();
    }

    // To exit from an address book
    public void exitAddressBook() {
            System.out.println("Exited from the Address book.");
            System.exit(0);

    }
   
}
