package com.example.laundryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Home extends Login{

    Button signout;
    GoogleSignInClient mGoogleSignInClient;
    TextView userName, userFirstName, userSecondName, userEmail, userId;
    ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        userName = (TextView) findViewById(R.id.name);
        userFirstName = (TextView) findViewById(R.id.firstname);
        userSecondName = (TextView) findViewById(R.id.secondname);
        userEmail = (TextView) findViewById(R.id.email);
        userId = (TextView) findViewById(R.id.userID);
        profileImage = (ImageView) findViewById(R.id.profileimage);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            userName.setText(personName);
            userFirstName.setText(personGivenName);
            userSecondName.setText(personFamilyName);
            userEmail.setText(personEmail);
            userId.setText(personId);
            Glide.with(this).load(personPhoto).into(profileImage);
        }

        signout = (Button) findViewById(R.id.so);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSO();
            }
        });
    }
        /*signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                switch (view.getId())
                {
                    case R.id.so:
                        signOut();
                        break;
                }   }  });}*/

    /*private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Home.this, "User Signed Out Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    } });  }}*/

        public void openSO() {
            mGoogleSignInClient.signOut()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            navigateUpTo(new Intent(getBaseContext(), Login.class));
                        }
                    });

        }
    }