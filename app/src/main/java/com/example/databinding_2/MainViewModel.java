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
        userList.add(new User("can1", "ca1@gmail.com"));
        userList.add(new User("can2", "can2@gmail.com"));
        userList.add(new User("can3", "cann4@gmail.com"));
        userList.add(new User("can4", "cann5@gmail.com"));
        userList.add(new User("can5", "canndsgsfd@gmail.com"));
        userList.add(new User("can6", "casdfsdsfdnn@gmail.com"));

        this.userMutable.setValue(userList);
    }


}
