package fr.esiea.ex4A.hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class AgifyClientIT {
    @Test
    void verify_result_requests_Agify() throws Exception {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> user = test.giveUserAge("Armel","FR");
        AgifyUser userFinal = user.execute().body();
        Assertions.assertEquals(56,userFinal.getAge());
        Assertions.assertEquals("FR",userFinal.getCountryId());
        Assertions.assertEquals(595,userFinal.getCount());
        Assertions.assertEquals("Armel", userFinal.getName());
    }
}
