package com.jd.mvvmexample;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.jd.mvvmexample.repository.retrofit.model.Image;
import com.jd.mvvmexample.viewmodel.MainActivityViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    ActivityMainBinding activityMainBinding;
    private MainActivityViewModel model;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         model = ViewModelProviders.of(MainActivity.this).get(MainActivityViewModel.class);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model.getImages().observe(MainActivity.this, new Observer<List<Image>>() {
            @Override
            public void onChanged(@Nullable List<Image> images) {
                Log.d("data1",images.size()+"");
                HerosAdapter adapter = new HerosAdapter(MainActivity.this, images);
                recyclerView.setAdapter(adapter);

            }
        });






    }
}
