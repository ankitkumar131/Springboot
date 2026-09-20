package com.course.day01;

/**
 * Run from the examples folder:
 *
 * javac -d out src/com/course/day01/*.java
 * java -cp out com.course.day01.Day01App
 */
public class Day01App {

    public static void main(String[] args) {
        UserRepository repository = new InMemoryUserRepository();
        UserService service = new UserService(repository);

        User ada = service.create("Ada", "ada@example.com");
        System.out.println("Created: " + ada);

        User found = service.getById(ada.id());
        System.out.println("Found: " + found);

        System.out.println("Active users: " + service.listActive());
        System.out.println("Search 'ad': " + service.searchByName("ad"));

        User renamed = service.updateEmail(ada.id(), "ada.lovelace@example.com");
        System.out.println("Updated: " + renamed);

        try {
            service.create("Ada 2", "ada.lovelace@example.com");
        } catch (IllegalStateException ex) {
            System.out.println("Expected duplicate: " + ex.getMessage());
        }

        try {
            service.getById(999L);
        } catch (UserNotFoundException ex) {
            System.out.println("Expected missing: " + ex.getMessage());
        }
    }
}
