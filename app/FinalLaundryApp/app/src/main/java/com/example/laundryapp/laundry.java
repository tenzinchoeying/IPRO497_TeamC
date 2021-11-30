package com.example.laundryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class laundry extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laundry);

        button = (Button) findViewById(R.id.cun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCunning();
            }
        });
        button = (Button) findViewById(R.id.gun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGun();
            }
        });
        button = (Button) findViewById(R.id.kac);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKacek();
            }
        });
        button = (Button) findViewById(R.id.msv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMSV();
            }
        });
        button = (Button) findViewById(R.id.rowe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRowe();
            }
        });

    }
    public void openCunning() {
        Intent intent = new Intent(this, Cunning.class);
        startActivity(intent);
    }
    public void openKacek() {
        Intent intent = new Intent(this, Kacek.class);
        startActivity(intent);
    }
    public void openGun() {
        Intent intent = new Intent(this, Gun.class);
        startActivity(intent);
    }
    public void openMSV() {
        Intent intent = new Intent(this, MSV.class);
        startActivity(intent);
    }
    public void openRowe() {
        Intent intent = new Intent(this, Rowe.class);
        startActivity(intent);
    }
}
