package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VeranstaltungErstellen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_veranstaltung_erstellen);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),AdminPage.class);
        startActivity(i);
    }
}
