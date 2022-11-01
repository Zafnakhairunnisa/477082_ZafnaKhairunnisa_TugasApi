package com.example.tugasapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    Context context;
    String userName[];
    String email[];
    String dateOfBirth[];
    String rGender[];
    String phoneNumber[];
    String imageURL[];

    public UsersAdapter(Context context, String[] userName, String[] email, String[] dateOfBirth, String[] rGender, String[] phoneNumber, String[] imageUrl) {
        this.context = context;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.rGender = rGender;
        this.phoneNumber = phoneNumber;
        this.imageURL = imageUrl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtUsername.setText(userName[position]);
        holder.txtEmail.setText(email[position]);

        Picasso.with(context).load(imageURL[position]).into(holder.imageView);

        holder.txtBirth.setText(dateOfBirth[position]);
        holder.txtGender.setText(rGender[position]);
        holder.txtPhone.setText(phoneNumber[position]);
    }

    @Override
    public int getItemCount() {
        return userName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtUsername, txtEmail, txtBirth, txtGender, txtPhone;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtUsername = itemView.findViewById(R.id.txt_username);
            txtEmail = itemView.findViewById(R.id.txt_email);
            txtBirth = itemView.findViewById(R.id.txt_birth);
            txtGender = itemView.findViewById(R.id.txt_gender);
            txtPhone = itemView.findViewById(R.id.txt_phone);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
