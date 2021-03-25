package fr.esiea.ex4A.hello;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface AgifyClient {
    @GET("/")
    Call<Map<String,String>> getAgeUser(@Query("name") String name, @Query("country_id") String countryId);
}
