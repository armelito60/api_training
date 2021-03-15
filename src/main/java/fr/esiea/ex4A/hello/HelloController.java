package fr.esiea.ex4A.hello;

import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
class HelloController {

    private final HelloRepository helloRepository;

    HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @ResponseBody
    @PostMapping(value="/api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    boolean userIdentified(@RequestBody Map<String,String> requestBody) {
        User user = new User(requestBody.get("userEmail"), requestBody.get("userName"), requestBody.get("userTweeter"), requestBody.get("userCountry"), requestBody.get("userSex"), requestBody.get("userSexPref"));
        helloRepository.userAdded(user);
        return true;
    }
}
