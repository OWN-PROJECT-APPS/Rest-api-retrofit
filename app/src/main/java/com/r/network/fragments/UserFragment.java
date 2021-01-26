package com.r.network.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.r.network.R;
import com.r.network.adapters.AdapterUsersList;
import com.r.network.models.User;
import java.util.ArrayList;

public class UserFragment extends Fragment{

    private ArrayList<User> users ;
    private AdapterUsersList adapterUsersList;

    public UserFragment(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.userList);
        adapterUsersList = new AdapterUsersList(users);
        listView.setAdapter(adapterUsersList);
    }


}