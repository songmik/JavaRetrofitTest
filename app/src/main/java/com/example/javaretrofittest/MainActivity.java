package com.example.javaretrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.javaretrofittest.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String key = "E25063E7B495514941EBD9CA8BF4EF291F1855B94D5205D4EE1AFBECAFF1EE34";
    private TextView tV;
    private RetrofitInterfaceService interfaceService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        interfaceService = RetrofitClient.getClient().create(RetrofitInterfaceService.class);

        Call<BookDto> call = interfaceService.getBook(key);
        call.enqueue(new Callback<BookDto>() {
            @Override
            public void onResponse(Call<BookDto> call, Response<BookDto> response) {
                if (response.isSuccessful()){
                    BookDto result = response.body();
                    binding.textView.setText(result.getTitle());
                }
            }

            @Override
            public void onFailure(Call<BookDto> call, Throwable t) {
                Log.e("TAG", t.toString());

            }
        });
    }
}