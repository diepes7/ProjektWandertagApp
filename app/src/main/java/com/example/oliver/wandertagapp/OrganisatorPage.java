package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class OrganisatorPage extends AppCompatActivity {

    private ListView lvVeranstaltungen;
    private ListView lvTeilnehmer;
    private Button startTracking;
    private MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisator_page);

        initVariables();
        setLvVeranstaltungItems();
    }

    private void initVariables() {
        lvVeranstaltungen = (ListView) findViewById(R.id.listViewVeranstaltungen);
        lvTeilnehmer = (ListView) findViewById(R.id.listViewTeilnehmer);
        startTracking = (Button) findViewById(R.id.buttonStartTracking);
        mainActivity = new MainActivity();

        startTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMapView();
            }
        });

        lvVeranstaltungen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Veranstaltung v = (Veranstaltung) lvVeranstaltungen.getItemAtPosition(i);
                setLvTeilnehmerItems(v.getTeilnehmerList());
            }
        });
    }

    private void setLvTeilnehmerItems(List<Teilnehmer> teinehmer) {
        ArrayAdapter<Teilnehmer> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, teinehmer);
        lvTeilnehmer.setAdapter(adapter);
    }

    private void showMapView() {
        Intent i = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(i);
    }

    private void setLvVeranstaltungItems() {
        ArrayAdapter<Veranstaltung> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mainActivity.al_Veranstaltungen);
        lvVeranstaltungen.setAdapter(adapter);
    }
}
