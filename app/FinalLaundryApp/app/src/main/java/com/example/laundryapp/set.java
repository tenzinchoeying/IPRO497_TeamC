package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class set extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);

        button = (Button) findViewById(R.id.tacbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTAC();
            }
        });
        button = (Button) findViewById(R.id.reportbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaint();
            }
        });
    }

    public void openTAC() {
        Intent intent = new Intent(this, tac_page.class);
        startActivity(intent);
    }
    public void openMaint() {
        Intent intent = new Intent(this, Maint.class);
        startActivity(intent);
    }
}