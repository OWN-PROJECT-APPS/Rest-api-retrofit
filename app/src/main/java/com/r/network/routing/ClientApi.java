package com.r.network.routing;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {
 static  final  String BASE_URL = "https://reqres.in/api/";
   public static Retrofit getClient(){
       return new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
   }
}
