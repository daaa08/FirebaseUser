package com.example.da08.firebaseuser;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.da08.firebaseuser.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Da08 on 2017. 7. 3..
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.Holder>{
    List<User> data = new ArrayList<>();

    public void setData(List<User> data){
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        User user = data.get(position);
        holder.txtName.setText(user.username);
        holder.txtEmail.setText(user.email);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView txtName, txtEmail;

        public Holder(View itemView){
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtEmail = (TextView)itemView.findViewById(R.id.txtEmail);
        }
    }
}
