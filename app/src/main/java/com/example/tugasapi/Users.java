package com.example.tugasapi;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("email")
    private String email;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("date_of_birth")
    private String date_of_birth;

    @SerializedName("gender")
    private String gender;

    @SerializedName("phone_number")
    private String phone_number;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
