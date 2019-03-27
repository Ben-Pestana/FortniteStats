package com.hfad.fortnitestats;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FortniteTrackerNetwork {

    @Headers("TRN-Api-Key: febc12a2-7983-4671-9634-d441d5fa8956")
    @GET("v1/profile/{console}/{username}")
    Call<FortniteResponse> search(@Path("console") String console, @Path("username") String username);
}
