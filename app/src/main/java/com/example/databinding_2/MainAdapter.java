package com.example.databinding_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding_2.databinding.ItemsBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<User> userList;
    private MainViewModel mainViewModel;

    public MainAdapter(List<User> userList, MainViewModel mainViewModel) {
        this.userList = userList;
        this.mainViewModel = mainViewModel;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemsBinding itemsBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.items, parent, false);
        return new MainViewHolder(itemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        User users = userList.get(position);
        holder.setBinding(users, mainViewModel);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        ItemsBinding binding;

        public MainViewHolder(@NonNull ItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setBinding(User user, MainViewModel viewModel) {
            binding.setUser(user);
            binding.setViewModel(viewModel);
            binding.executePendingBindings();
        }
    }

}
