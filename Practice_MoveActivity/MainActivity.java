package com.androidpark.project_6_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_move;
    private EditText edit_text;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인페이지");

        btn_move = (Button)findViewById(R.id.btn_move);
        edit_text = (EditText)findViewById(R.id.edit_text);


        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = edit_text.getText().toString();
                Intent intent = new Intent(MainActivity.this,SubActivity.class); // 해당 링크로 이동
                intent.putExtra("str",str);
                startActivity(intent); // 액티비티 이동
            }
        });

    }
}