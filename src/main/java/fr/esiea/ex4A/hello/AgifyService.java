package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    private final AgifyClient client;
    private final MainRepository mainRepository;

    public AgifyService(AgifyClient client, MainRepository mainRepository) {
        this.client = client;
        this.mainRepository = mainRepository;
    }

    public AgifyUser userAge(String name, String country) throws IOException {
        return (AgifyUser) client.getAgeUser(name, country).execute().body();
    }

    public ArrayList<Match> getMatch(int goalAge) throws IOException {
        ArrayList<Match> matches = new ArrayList<>();
        for(User match : mainRepository.getUserSubscribed()) {
            AgifyUser foundMatch = userAge(match.getUserName(), match.getUserCountry());
            if(foundMatch.getAge() - goalAge < 5 && foundMatch.getAge() - goalAge > - 5) {
                matches.add(new Match(match.getUserName(), match.getUserTweeter()));
            }
        }
        return matches;
    }

}
