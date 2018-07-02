package com.example.thomas.androidarchitecture.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.androidarchitecture.ArchitectureApplication;
import com.example.thomas.androidarchitecture.R;
import com.example.thomas.androidarchitecture.data.User;
import com.example.thomas.androidarchitecture.databinding.UserProfileBinding;
import com.example.thomas.androidarchitecture.viewmodel.UserProfileViewModel;
import com.example.thomas.androidarchitecture.viewmodel.ViewModelFactory;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

public class UserProfileFragment extends Fragment {

    @Inject
    ViewModelFactory<UserProfileViewModel> viewModelFactory;

    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;
    private UserProfileBinding binding;

    public static UserProfileFragment newInstance(String userId) {
        UserProfileFragment fragment = new UserProfileFragment();

        // Use arguments so that if the fragment is recreated it keeps maintains user id
        Bundle arguments = new Bundle();
        arguments.putString(UID_KEY, userId);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //TODO: Work out how to use this
        ((ArchitectureApplication)getActivity().getApplication()).getApplicationComponent().inject(this);

        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserProfileViewModel.class);
        viewModel.init(userId);

        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    binding.txtUserName.setText(user.getLogin());

                    //TODO: This is repeating what we do in with data binding calling the view model
                    binding.txtLastUpdated.setText(user.getLastUpdated().toString());
                }
            }
        });

        binding.setViewModel(viewModel);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                viewModel.init("beeftuck");
            }
        }, 0, 10000);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.user_profile, container, false);
        return binding.getRoot();
    }
}
