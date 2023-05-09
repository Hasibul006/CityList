package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showactivity);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name").trim();
        TextView text = findViewById(R.id.textView);
        Button show = findViewById(R.id.button);
        text.setText(name);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(show.getContext(),MainActivity.class));
                finish();
            }
        });
    }
}