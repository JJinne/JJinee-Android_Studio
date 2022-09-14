package com.androidpark.project_6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private TextView subText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        setTitle("서브페이지");

        subText = (TextView)findViewById(R.id.subText);
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        subText.setText(str);

    }
}