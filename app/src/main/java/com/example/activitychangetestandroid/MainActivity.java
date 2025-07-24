package com.example.activitychangetestandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            final EditText nameText = (EditText) findViewById(R.id.nameText);       //이름 입력 창
            Button nameButton = (Button) findViewById(R.id.nameButton);             //전송 버튼

            nameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = nameText.getText().toString();
                    if (name.length() > 0) {
                        //  인텐트 = 새로운 창을 열기 위한 객체
                        //SubActivity라는 창으로 보내기 위함
                        Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                        //name이라는 변수로 보낼 수 있도록
                        intent.putExtra("nameText",name);
                        //인텐트 실행
                        startActivity(intent);

                    }
                }
            });

            return insets;  // 메인 리턴문
        });
    }
}