package edu.escuelaing.arsw.taller2.app.Lambda;

public class CheckPersonEligibleForSelectiveService implements CheckPerson{

    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.FEMALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}
