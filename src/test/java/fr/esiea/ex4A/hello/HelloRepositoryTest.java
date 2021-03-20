package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HelloRepositoryTest {

    private final HelloRepository helloRepository = new HelloRepository();

    @Test
    void HelloRepository() {

    }

    @Test
    void getUserSubscribed() {
        Assertions.assertEquals(5, helloRepository.getUserSubscribed().size());
    }

    @Test
    void userAddedTrue() {
        User user3 = new User("Laura@etudiant.fr", "Laura", "Laura", "EN", "F", "M");
        Assertions.assertTrue(helloRepository.userAdded(user3));
    }

    @Test
    void userAddedFalse() {
        User user4 = new User("Jules@etudiant.fr", "Jules", "Jules", "IT", "M", "F");
        helloRepository.userAdded(user4);
        Assertions.assertFalse(helloRepository.userAdded(user4));
    }

}
