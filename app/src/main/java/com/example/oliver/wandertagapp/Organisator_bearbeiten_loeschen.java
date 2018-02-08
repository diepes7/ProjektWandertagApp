package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Organisator_bearbeiten_loeschen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_organisator_bearbeiten_loeschen);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),AdminPage.class);
        startActivity(i);
    }
}
