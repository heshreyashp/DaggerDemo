package com.example.daggerdemo.screenui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daggerdemo.DaggerAppComponent;
import com.example.daggerdemo.R;
import com.example.daggerdemo.model.ProductList;
import com.example.daggerdemo.viiewmodel.MainActivityViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel viewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        // Dagger 2 injection
        DaggerAppComponent.create().inject(this);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Observe the LiveData from the ViewModel
        viewModel.getPosts().observe(this, posts -> {
            if (posts != null && posts.size() > 0) {
                for (ProductList post : posts) {
                    textView.append("\n " + post.getTitle() + "");
                }
            }
            Toast.makeText(this, "Posts: " + posts.size() + "\n" + posts.get(0).getText(), Toast.LENGTH_SHORT).show();
            // Update your UI with the list of posts
        });
    }
}
