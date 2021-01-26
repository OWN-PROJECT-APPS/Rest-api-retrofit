package com.r.network.routing;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("users")
    Call<PojoMultipleUser> getAllUsers();
    @GET("users/{userId}")
    Call<Pojo> getOneUser(@Path("userId") long userId);
}


