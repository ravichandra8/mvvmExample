package com.jd.mvvmexample.repository;

import android.util.Log;
import com.jd.mvvmexample.RetrofitServiceBuilder;
import com.jd.mvvmexample.repository.retrofit.model.IMResponse;
import com.jd.mvvmexample.repository.retrofit.model.ParentResponse;
import com.jd.mvvmexample.repository.retrofit.service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource implements DataContract {

    private static RemoteDataSource instance=null;

    public static RemoteDataSource getInstance()
    {
        if (instance == null) {
            instance = new RemoteDataSource();
        }
        return instance;
    }

    @Override
    public void getPSdetails(final callBack callBack) {

       Service service=RetrofitServiceBuilder.createService(Service.class);

       service.GetSCPSList("3201").enqueue(new Callback<ParentResponse>() {
           @Override
           public void onResponse(Call<ParentResponse> call, Response<ParentResponse> response) {
               Log.d("execute","execute");
               callBack.success(response.body());
           }

           @Override
           public void onFailure(Call<ParentResponse> call, Throwable t) {
               Log.d("execute-error","execute-error");
               callBack.failure("error");

           }
       });

    }

    @Override
    public void getImages(final ImageCallBack imageCallBack) {
        Service service=RetrofitServiceBuilder.createService(Service.class);
        service.getAllImages("8439361-5e1e53a0e1b58baa26ab398f7").enqueue(
            new Callback<IMResponse>() {
                @Override
                public void onResponse(Call<IMResponse> call, Response<IMResponse> response) {
                    if(response.isSuccessful()){
                        Log.d("data execute","execute");
                        imageCallBack.success(response.body().getImages());
                    }
                }

                @Override
                public void onFailure(Call<IMResponse> call, Throwable t) {

                }
            });
    }
}
