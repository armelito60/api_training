package fr.esiea.ex4A.hello;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyUser> giveUserAge(@Query("name") String names, @Query("country_id") String country);
}
