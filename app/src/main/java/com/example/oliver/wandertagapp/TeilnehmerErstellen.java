package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TeilnehmerErstellen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teilnehmer_erstellen);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),AdminPage.class);
        startActivity(i);
    }
}
