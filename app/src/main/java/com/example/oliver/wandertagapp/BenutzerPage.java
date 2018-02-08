package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class BenutzerPage extends AppCompatActivity {
    private ListView lvVeranstaltungen;
    private ListView lvTeilnehmer;
    private Button startTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisator_page);

        initVariables();

        showMapView();
    }

    private void initVariables() {
        lvVeranstaltungen = (ListView) findViewById(R.id.listViewVeranstaltungen);
        lvTeilnehmer = (ListView) findViewById(R.id.listViewTeilnehmer);
        startTracking = (Button) findViewById(R.id.buttonStartTracking);
    }

    private void showMapView() {
        Intent i = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(i);
    }
}
