package com.example.javaretrofittest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterfaceService {

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    Call<BookDto> getBook(@Query("key") String apiKey);
}

/*

Interface에 작성된 코드를 Http API로 전환해준다.
요청할 API에 대한 것만 작성

반환 타입 : Call<객체>

*/