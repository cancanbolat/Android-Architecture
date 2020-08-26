package com.example.databinding_2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<User>> userMutable = new MutableLiveData<>();

    public MutableLiveData<List<User>> getUserMutable() {
        return userMutable;
    }

    public void setUserMutable() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("can", "c@gmail.com"));
        userList.add(new User("can1", "ca@gmail.com"));
        userList.add(new User("can2", "can@gmail.com"));
        userList.add(new User("can3", "cann@gmail.com"));

        this.userMutable.setValue(userList);
    }


}
