package com.hands_on_android.dogviewerjava;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.dogviewerjava.network.ServiceGenerator;
import com.hands_on_android.dogviewerjava.network.model.BreedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Jay Raj Thapa
//A00213690

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView dogListRecyclerView = findViewById(R.id.recyclerView);

        BreedListAdapter adapter = new BreedListAdapter(breed -> {
            Toast.makeText(this, breed.getTitle(), Toast.LENGTH_SHORT).show();
        });
        dogListRecyclerView.setAdapter(adapter);

        ServiceGenerator.getService().getBreedList().enqueue(new Callback<BreedList>() {
            @Override
            public void onResponse(Call<BreedList> call, Response<BreedList> response) {
                if(response.body() != null && response.isSuccessful()){
                    adapter.setBreedNames(response.body().getBreeds());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BreedList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
