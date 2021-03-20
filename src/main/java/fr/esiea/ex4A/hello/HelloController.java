package fr.esiea.ex4A.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
class HelloController {

    private final HelloRepository helloRepository;
    private final AgifyClient client;
    private final AgifyService agifyService;

    HelloController(AgifyClient client, AgifyService agifyService, HelloRepository helloRepository) {
        this.client = client;
        this.agifyService = agifyService;
        this.helloRepository = helloRepository;
    }

    @ResponseBody
    @PostMapping(path="/api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    boolean userIdentified(@RequestBody Map<String,String> requestBody) {
        User user = new User(requestBody.get("userEmail"), requestBody.get("userName"), requestBody.get("userTweeter"), requestBody.get("userCountry"), requestBody.get("userSex"), requestBody.get("userSexPref"));
        return helloRepository.userAdded(user);
    }

    @GetMapping(path="/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String match(@RequestParam(name = "userName", required = true) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws IOException {
        client.getAgeUser(userName, userCountry);
        AgifyUser principal = agifyService.userAge(userName, userCountry);
        List<Match> matches = agifyService.getMatch(principal.getAge());
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(matches);
        return result;
    }
}
