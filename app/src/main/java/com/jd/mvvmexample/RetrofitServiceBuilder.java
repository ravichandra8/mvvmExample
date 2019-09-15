package com.jd.mvvmexample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitServiceBuilder {

    private static final String BASE_URL = "https://pixabay.com/";
    private static Retrofit retrofit;

    public static void init() {

        if (retrofit == null) {

            // http client
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            // Add interceptors

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(Level.BODY);

            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            //.client(client)
                            .addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();
        }
    }

    public static <S> S createService(
            Class<S> serviceClass) {

        return retrofit.create(serviceClass);
    }

}
