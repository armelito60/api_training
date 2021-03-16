package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void Constructor() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertNotNull(user);
    }

    @Test
    void getUserEmail() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertEquals("tchiasso@et.esiea.fr", user.getUserEmail());
    }

    @Test
    void getUserName() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertEquals("Armel", user.getUserName());
    }

    @Test
    void getUserTweeter() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertEquals("armelito", user.getUserTweeter());
    }

    @Test
    void getUserCounter() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertEquals("France", user.getUserCountry());
    }

    @Test
    void getUserSex() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertEquals("M", user.getUserSex());
    }

    @Test
    void getUserSexPref() {
        User user = new User("tchiasso@et.esiea.fr", "Armel", "armelito", "France", "M", "F");
        Assertions.assertEquals("F", user.getUserSexPref());
    }
}
