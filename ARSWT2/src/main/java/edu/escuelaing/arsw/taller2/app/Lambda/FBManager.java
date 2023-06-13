package edu.escuelaing.arsw.taller2.app.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FBManager {
    public static void main(String[] args){
        List<Person> personas = new ArrayList<Person>();
        printPersons(personas, new CheckPersonEligibleForSelectiveService()); //Tercera opcion

        printPersons(personas, new CheckPerson() {
                    public boolean test(Person p) {
                        return p.gender == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 30;
                    }
                }
        ); // Cuarta opcion

        printPersons(personas, (Person p) -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 29
        ); //Quinta solucion

        printPersonsWithPredicate(personas, p -> p.gender == Person.Sex.FEMALE
                && p.getAge() >= 18
                && p.getAge() <= 25); //Sexta opcion


        processPersons(personas, p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 29,
                p -> p.printPerson()); //Septima opcion 1

        processPersonsWithFunction(
                personas,
                p -> p.gender == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 29,
                p -> p.emailAddress,
                email -> System.out.println("email: " + email)
        );  // Septima opcion 2


//        processElements(
//                roster,
//                p -> p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25,
//                p -> p.getEmailAddress(),
//                email -> System.out.println(email)
//        );
        personas.stream()
                .filter(
                        p -> p.gender == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 40)
                .map(p -> p.emailAddress)
                .forEach(email -> System.out.println(email));
    }

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
                         Function<X, Y> mapper,Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster,Predicate<Person> tester,
                                                  Function<Person, String> mapper,
                                                  Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    public static void processPersons(List<Person>lista,
                                      Predicate<Person> tester,
                                      Consumer<Person> block) {
        for (Person p : lista) {
            if (tester.test(p)) {
                block.accept(p);
            }}}

    public static void printPersonsWithPredicate(
            List<Person> lista, Predicate<Person> tester) {
        for (Person p : lista) {
            if (tester.test(p)) {
                p.printPerson();
            }}}

    public static void printPersonsOlderThan(List<Person> lista, int age) {
        for (Person p : lista) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> lista, int low, int high) {
        for (Person p : lista) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}
