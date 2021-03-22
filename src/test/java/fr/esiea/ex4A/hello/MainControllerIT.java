package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HelloControllerIT {

    private final MockMvc mockMvc;

    HelloControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void match() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=Lilian&userCountry=FR"))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                        [{"name":"Guillaume","twitter":"Guillaume"},{"name":"Julie","twitter":"Julie"}]
                        """));
    }

    @Test
    void userRegistered() throws Exception {
        User user = new User("tchiasso@gmail.com", "Tchiass", "ATchiasso", "FR", "M", "F");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(user);
        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(result)
            )
            .andExpect(status().isOk())
            .andExpect(content().string("true"));
    }
}
