package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainRepositoryTest {

    private final MainRepository mainRepository = new MainRepository();

    @Test
    void HelloRepository() {

    }

    @Test
    void getUserSubscribed() {
        Assertions.assertEquals(5, mainRepository.getUserSubscribed().size());
    }

    @Test
    void userAddedTrue() {
        User user3 = new User("Laura@etudiant.fr", "Laura", "Laura", "EN", "F", "M");
        Assertions.assertTrue(mainRepository.userAdded(user3));
    }

    @Test
    void userAddedFalse() {
        User user4 = new User("Jules@etudiant.fr", "Jules", "Jules", "IT", "M", "F");
        mainRepository.userAdded(user4);
        Assertions.assertFalse(mainRepository.userAdded(user4));
    }

}
