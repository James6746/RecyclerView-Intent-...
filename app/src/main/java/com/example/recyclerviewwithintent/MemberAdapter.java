package com.example.recyclerviewwithintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Member> members;
    OnClick onClick;

    public MemberAdapter(Context context, ArrayList<Member> members, OnClick onClick) {
        this.context = context;
        this.members = members;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MemberViewHolder){
            ((MemberViewHolder) holder).tv_name.setText(members.get(position).getName());
            ((MemberViewHolder) holder).tv_age.setText(String.valueOf(members.get(position).getAge()));

            ((MemberViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.accomplish(holder.getAdapterPosition());
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name;
        public TextView tv_age;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
        }
    }

    public interface OnClick{
        public void accomplish(int position);
    }
}