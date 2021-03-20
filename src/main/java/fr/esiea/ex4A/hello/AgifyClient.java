package fr.esiea.ex4A.hello;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyUser> getAgeUser(@Query("name") String name, @Query("country_id") String countryId);
}
