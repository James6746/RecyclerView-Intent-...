package com.example.recyclerviewwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView tv_name;
    TextView tv_age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);

        Member member = getIntent().getParcelableExtra("Member");

        tv_name.setText(member.getName());
        tv_age.setText(String.valueOf(member.getAge()));

    }
}