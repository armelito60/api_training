package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Repository
class HelloRepository {
    final List<User> userSubscribed = new ArrayList<>();

    public HelloRepository() {
        User user1 = new User("guillaume@etudiant.fr", "Guillaume", "Guillaume", "FR", "M", "M");
        userSubscribed.add(user1);
        User user2 = new User("valentin@etudiant.fr", "Valentin", "Valentin", "FR", "M", "F");
        userSubscribed.add(user2);
        User user3 = new User("matteo@etudiant.fr", "Matteo", "Matteo", "FR", "M", "F");
        userSubscribed.add(user3);
        User user4 = new User("alexia@etudiant.fr", "Alexia", "Alexia", "FR", "F", "M");
        userSubscribed.add(user4);
        User user5 = new User("julie@etudiant.fr", "Julie", "Julie", "FR", "F", "M");
        userSubscribed.add(user5);
    }

    boolean userAdded(User user) {
        if(userSubscribed.contains(user)) {
            return false;
        }
        else {
            userSubscribed.add(user);
            return true;
        }
    }

}
