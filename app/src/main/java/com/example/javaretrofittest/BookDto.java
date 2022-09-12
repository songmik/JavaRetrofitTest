package com.example.javaretrofittest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDto {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("item")
    @Expose
    private List<Book> books;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

/*

 Retrofit으로 HTTP API 호출할 때 해당 DTO를 넘긴다. (이 DTO를 통해 데이터를 받을 것임)
 DTO(Data Transfer Object) : 데이터 전송 객체로, 계층 간 데이터 교환을 위해 사용되는 객체이다.

*/