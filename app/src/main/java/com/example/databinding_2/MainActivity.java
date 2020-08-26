package com.example.databinding_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.os.Bundle;

import com.example.databinding_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainNavigator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainViewModel viewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        viewModel.setNavigator(this);
        viewModel.setUserMutable();
        viewModel.getUserMutable().observe(this, user -> {
            mainBinding.recyclerView.setAdapter(new MainAdapter(user, viewModel));
        });


    }

    @Override
    public void onItemClick(User user) {
        new AlertDialog.Builder(this).setMessage(user.name + "\n" + user.email).show();
    }

}