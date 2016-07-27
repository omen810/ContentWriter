package com.omen.contentwriter;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonWrite = (Button) findViewById(R.id.activity_main_btn_write);
        mButtonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write();
            }


        });
    }

    private void write() {
        ContentValues values = new ContentValues();
        values.put("name", "android");
        getContentResolver().insert(MyProvider.URI, values);
        values.put("name", "Java");
        getContentResolver().insert(MyProvider.URI, values);
        values.put("name", "PHP");
        getContentResolver().insert(MyProvider.URI, values);

    }
}
