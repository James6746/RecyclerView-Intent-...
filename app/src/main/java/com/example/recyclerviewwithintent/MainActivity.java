package com.example.recyclerviewwithintent;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MemberAdapter memberAdapter;
    MemberAdapter.OnClick onClick;
    ArrayList<Member> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        onClick = new MemberAdapter.OnClick() {
            @Override
            public void accomplish(int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("Member", members.get(position));
                startActivity(intent);
            }
        };

        refreshAdapter(getMembers());
    }

    private ArrayList<Member> getMembers() {
        members = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            members.add(new Member(i + " Jamshid", 5 + i));
        }

        return members;
    }

    private void refreshAdapter(ArrayList<Member> members) {
        memberAdapter = new MemberAdapter(this, members, onClick);
        recyclerView.setAdapter(memberAdapter);
    }
}