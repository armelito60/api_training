package fr.esiea.ex4A.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
class HelloController {

    private final HelloRepository helloRepository;

    HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @ResponseBody
    @PostMapping(path="/api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    boolean userIdentified(@RequestBody Map<String,String> requestBody) {
        User user = new User(requestBody.get("userEmail"), requestBody.get("userName"), requestBody.get("userTweeter"), requestBody.get("userCountry"), requestBody.get("userSex"), requestBody.get("userSexPref"));
        helloRepository.userAdded(user);
        return true;
    }

    @GetMapping(path="/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String match(@RequestParam(name = "userName", required = true) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Match match = new Match("one","one");
        Match match2 = new Match("two","two");
        List<Match> matches = new ArrayList<>();
        matches.add(match);
        matches.add(match2);
        String result = mapper.writeValueAsString(matches);
        return result;
    }
}
