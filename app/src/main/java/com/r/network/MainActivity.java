package com.r.network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.r.network.fragments.UserFragment;
import com.r.network.models.User;
import com.r.network.routing.ApiServices;
import com.r.network.routing.ClientApi;
import com.r.network.routing.Pojo;
import com.r.network.routing.PojoMultipleUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    FragmentManager fragmentManager;
    Button getOneUser,getAllUsers;
    ProgressDialog progressDialog;
    ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getOneUser = findViewById(R.id.getOneUser);
        getAllUsers = findViewById(R.id.getAllUsers);
        fragmentManager =  getSupportFragmentManager();
        getOneUser.setOnClickListener(this);
        getAllUsers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.getAllUsers:
                getAllUsers();

                break;

            case R.id.getOneUser:
                 getUser();
                break;
        }

    }
        public void getUser(){
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Fetch User Info");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            ApiServices clientApi = ClientApi.getClient().create(ApiServices.class);
            Call<Pojo> call = clientApi.getOneUser(2);
            call.enqueue(new Callback<Pojo>() {
                @Override
                public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                    users = new ArrayList<>();
                    if(response.code() == 200){
                        assert response.body() != null;
                        users.add(response.body().getUser());
                        fragmentManager.beginTransaction().replace(R.id.holder, new UserFragment(users)).commit();
                    }
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<Pojo> call, Throwable t) {
                    Log.d("output",t.getMessage());
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Opps !! Check Your Internet And Try Again",Toast.LENGTH_SHORT).show();

                }
            });

    }

    public void getAllUsers(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Fetch Users ");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        ApiServices clientApi = ClientApi.getClient().create(ApiServices.class);
        Call<PojoMultipleUser> call = clientApi.getAllUsers();
        call.enqueue(new Callback<PojoMultipleUser>() {
            @Override
            public void onResponse(Call<PojoMultipleUser> call, Response<PojoMultipleUser> response) {

                if(response.code() == 200){
                    assert response.body() != null;
                    users = (ArrayList<User>) response.body().getAll();
                    fragmentManager.beginTransaction().replace(R.id.holder, new UserFragment(users)).commit();
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<PojoMultipleUser> call, Throwable t) {
                Log.d("output",t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Opps !! Check Your Internet And Try Again",Toast.LENGTH_SHORT).show();

            }
        });

    }
}