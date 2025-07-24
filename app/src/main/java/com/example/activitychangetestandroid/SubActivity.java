package com.example.activitychangetestandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//하나의 창이라면 extends AppCompatActivity를 상속 받아야함
public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_sub);
        TextView nameText = (TextView) findViewById(R.id.nameText);
        Intent intent = getIntent();  //넘어온 값들을 받음
        nameText.setText(intent.getStringExtra("nameText"));

    }
}