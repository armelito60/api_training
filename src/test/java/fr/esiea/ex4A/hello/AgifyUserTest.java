package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class AgifyUserTest {
    AgifyUser AgifyUserTest() throws IOException {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> user = test.giveUserAge("Armel","FR");

        AgifyUser userFinal = user.execute().body();
        return userFinal;
    }

    @Test
    void getName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("Armel",testUser.getName());

    }

    @Test
    void setName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setName("armelito");
        Assertions.assertEquals("armelito",testUser.getName());
    }

    @Test
    void getAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(56,testUser.getAge());
    }

    @Test
    void setAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setAge(23);
        Assertions.assertEquals(23,testUser.getAge());
    }

    @Test
    void getCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(595,testUser.getCount());
    }

    @Test
    void setCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setCount(500);
        Assertions.assertEquals(500,testUser.getCount());
    }

    @Test
    void getCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("FR",testUser.getCountryId());
    }

    @Test
    void setCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setCountryId("FR");
        Assertions.assertEquals("FR",testUser.getCountryId());
    }
}
