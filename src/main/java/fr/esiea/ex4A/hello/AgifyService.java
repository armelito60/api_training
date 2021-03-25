package fr.esiea.ex4A.hello;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AgifyService {

    private final AgifyClient client;
    private final MainRepository mainRepository;
    private final Map<String,Integer> cache = new HashMap<>();

    public AgifyService(AgifyClient client, MainRepository mainRepository) {
        this.client = client;
        this.mainRepository = mainRepository;
    }

    public AgifyUser userAge(String name, String country) throws IOException {
        Map<String, String> userMapped = client.getAgeUser(name,country).execute().body();
        AgifyUser userFinal =  new AgifyUser(userMapped.get("name"), Integer.parseInt(userMapped.get("age")),Integer.parseInt(userMapped.get("count")),userMapped.get("country_id"));
        return userFinal;
    }

    public ArrayList<Match> getMatch(int goalAge) throws IOException {
        ArrayList<Match> matches = new ArrayList<>();
        for(User match : mainRepository.getUserSubscribed()) {
            int ageUserMatch = getFromCache(match);
            if(ageUserMatch - goalAge < 4 && ageUserMatch - goalAge > - 4) {
                matches.add(new Match(match.getUserName(), match.getUserTweeter()));
            }
        }
        return matches;
    }

    public int getFromCache(User user) throws IOException {
        int value = 0;
        if(!cache.containsKey(user.getUserName()+"-"+user.getUserCountry())) {
            AgifyUser matchFind = userAge(user.getUserName(), user.getUserCountry());
            cache.put(user.getUserName()+"-"+user.getUserCountry(),matchFind.getAge());
            value = matchFind.getAge();
        }
        else {
            value = cache.get(user.getUserName()+"-"+user.getUserCountry());
        }
        return value;
    }

}
