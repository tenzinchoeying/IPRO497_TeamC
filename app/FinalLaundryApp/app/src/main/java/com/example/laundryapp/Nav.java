package com.example.laundryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Nav extends Login {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav);

        button = (Button) findViewById(R.id.laundry);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMain2();
            }
        });
        button = (Button) findViewById(R.id.res);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMSV();
            }
        });
        button = (Button) findViewById(R.id.so);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSO();
            }
        });
        button = (Button) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHOME();
            }
        });
        button = (Button) findViewById(R.id.maint);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMAINT();
            }
        });
        button = (Button) findViewById(R.id.set);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSET();
            }
        });
    }
    public void openMain2() {
        Intent intent = new Intent(this, laundry.class);
        startActivity(intent);
    }

    public void openMSV() {
        Intent intent = new Intent(this, msvbook.class);
        startActivity(intent);
    }

    public void openSO() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        navigateUpTo(new Intent(getBaseContext(), Login.class));
                    }
                });

    }

    public void openHOME() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void openMAINT() {
        Intent intent = new Intent(this, Maint.class);
        startActivity(intent);
    }
    public void openSET() {
        Intent intent = new Intent(this, set.class);
        startActivity(intent);
    }

}