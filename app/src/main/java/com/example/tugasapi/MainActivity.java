package com.example.tugasapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    TextView textView;
    private RecyclerView recyclerView;
    //private String[] arrUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_users);

//        textView = findViewById(R.id.text_view);

//        getRandomUser();
        getDataUser();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setAdapter(new UsersAdapter(this, arrUserName));

    }

//    private void getRandomUser(){
//        Call<Users> caller = RetrofitClient.getInstance().getMyApi().getUsers();
//
//        caller.enqueue(new Callback<Users>() {
//            @Override
//            public void onResponse(Call<Users> call, Response<Users> response) {
//                Users randomUser = response.body();
//                textView.setText(randomUser.getFirst_name());
//            }
//
//            @Override
//            public void onFailure(Call<Users> call, Throwable t) {
//
//            }
//        });
//    }

    private void getDataUser(){
        Call<List<Users>> caller = RetrofitClient.getInstance().getMyApi().getDataUsers(10);
        caller.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                List<Users> usersList = response.body();
                String users = "";

                String[] arrUserName = new String[usersList.size()];
                String[] arrEmail = new String[usersList.size()];
                String[] arrBirth = new String[usersList.size()];
                String[] arrGender = new String[usersList.size()];
                String[] arrPhoneNumber = new String[usersList.size()];
                String[] arrImageURL = new String[usersList.size()];

                for (int i=0; i<usersList.size(); i++){
                    Users currentUser = usersList.get(i);
                    arrUserName[i] = currentUser.getFirst_name() + " " + currentUser.getLast_name();
                    arrEmail[i] = "Email: " + currentUser.getEmail();
                    arrBirth[i] = "Date Of Birth: " + currentUser.getDate_of_birth();
                    arrGender[i] = "Gender: " + currentUser.getGender();
                    arrPhoneNumber[i] = "Contact: " + currentUser.getPhone_number();
                    arrImageURL[i] = currentUser.getAvatar();

                }

                //textView.setText(users);
                recyclerView.setAdapter(new UsersAdapter(MainActivity.this, arrUserName, arrEmail, arrBirth, arrGender, arrPhoneNumber, arrImageURL));
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });


    }
}