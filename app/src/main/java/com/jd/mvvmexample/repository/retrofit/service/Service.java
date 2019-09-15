package com.jd.mvvmexample.repository.retrofit.service;

import com.jd.mvvmexample.repository.retrofit.model.IMResponse;
import com.jd.mvvmexample.repository.retrofit.model.ParentResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {


    @GET("GetSCPSList")
    Call<ParentResponse> GetSCPSList(@Query("DistrictCd") String distcode);

    @GET("api/")
    Call<IMResponse> getAllImages(@Query("key") String apiKey);//, @Query("page") int page, @Query("per_page") String perPage);


}