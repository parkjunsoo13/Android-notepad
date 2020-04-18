package com.example.notepad_line;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddMemoActivity extends AppCompatActivity {

    EditText edtText;
    EditText edtText_title;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo);
        edtText = findViewById(R.id.edtMemo);
        edtText_title = findViewById(R.id.editTitle);

        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String mainText = edtText.getText().toString();
                String titleText = edtText_title.getText().toString();

                if(mainText.length() > 0){
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateText = sdf.format(date);
                    Intent intent = new Intent();
                    intent.putExtra("title",titleText);
                    intent.putExtra("main",mainText);
                    intent.putExtra("date",dateText);
                    setResult(0,intent);
                    finish();
                }
            }
        });

        findViewById(R.id.btnNo).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
