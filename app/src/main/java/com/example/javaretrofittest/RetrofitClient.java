package com.example.javaretrofittest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://book.interpark.com";

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

        }
        return retrofit;
    }
}


/*


싱글톤 : 생성자를 private 처리하여 외부에서 객체를 생성할 수 없게하고,
미리 생성해둔 객체를 외부 어디서든 반환받아 사용할 수 있도록 getClient() 이라는 static 메소드를 만들어줌

getClient()가 호출되면 Singleton에 새로운 객체를 할당해주게 되는데, 이미 객체가 할당되어있다면
그것을 그대로 반환하게 된다.
(객체가 두 번 이상 생성되는 것을 방지하지 위해 synchronized 를 붙여준다.)

public class RetrofitSingleton {
    private static RetrofitSingleton retrofitSingleton = null;
    private RetrofitSingleton() {}

    public static synchronized RetrofitSingleton getInstance() {
        if (retrofitSingleton == null) {
            retrofitSingleton = new RetrofitSingleton();
        }
        return  retrofitSingleton;
    }
}


*/