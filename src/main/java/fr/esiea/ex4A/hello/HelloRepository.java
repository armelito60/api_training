package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Repository
class HelloRepository {
    final List<User> userSubscribed = new ArrayList<>();

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
