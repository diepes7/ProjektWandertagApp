package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Stefan on 11.04.2018.
 */

public class OrganisatorCheckAttendance extends AppCompatActivity {

    Veranstaltung v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkattandance);
        InitIntent();
    }

    private void InitIntent() {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        if (params != null) {
            v = (Veranstaltung) params.get("veranstaltung");
        }
        Toast.makeText(getApplicationContext(),v.getBezeichnung(),Toast.LENGTH_SHORT);
    }
}
