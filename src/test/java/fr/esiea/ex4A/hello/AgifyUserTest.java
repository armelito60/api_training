package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Map;

public class AgifyUserTest {
    AgifyUser AgifyUserTest() throws IOException {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<Map<String,String>> user = test.getAgeUser("Armel","FR");
        Map<String, String> userFinal = user.execute().body();
        return new AgifyUser(userFinal.get("name"), Integer.parseInt(userFinal.get("age")),Integer.parseInt(userFinal.get("count")),userFinal.get("country_id"));
    }

    @Test
    void getName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("Armel",testUser.getName());

    }

    @Test
    void getAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(56,testUser.getAge());
    }

    @Test
    void getCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(595,testUser.getCount());
    }

    @Test
    void getCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("FR",testUser.getCountryId());
    }
}
