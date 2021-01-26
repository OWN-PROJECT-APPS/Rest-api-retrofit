package com.r.network.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.r.network.R;
import com.r.network.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class AdapterUsersList extends BaseAdapter {
    private ArrayList<User> users;

    public AdapterUsersList(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_user_layout,parent,false);
        }
        TextView fullName, userEmail;
        ImageView avatar;
        avatar = convertView.findViewById(R.id.userPicture);
        fullName = convertView.findViewById(R.id.fullName);
        userEmail = convertView.findViewById(R.id.userEmail);
        fullName.setText(getItem(position).getFullName());
        userEmail.setText(getItem(position).getEmail());
        Picasso.with(parent.getContext()).load(getItem(position).getAvatar()).error(R.drawable.avatar).into(avatar);
        return convertView;
    }
}
