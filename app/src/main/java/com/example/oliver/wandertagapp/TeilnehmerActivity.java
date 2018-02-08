package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Console;

public class TeilnehmerActivity extends AppCompatActivity {
    private ListView lv_Veranstaltungen;
    private MainActivity main = new MainActivity();
    Teilnehmer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teilnehmer);

        setListViewItems();
    }

    private void setListViewItems() {
        Intent intent  = getIntent();
        Bundle params = intent.getExtras();
        if(params != null)
        {
             t=(Teilnehmer) params.get("teilnehmer");
            Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();
        }
        lv_Veranstaltungen = (ListView) findViewById(R.id.lvVeranstaltungen);
        ArrayAdapter<Veranstaltung> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, main.al_Veranstaltungen);
        lv_Veranstaltungen.setAdapter(adapter);
        lv_Veranstaltungen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Veranstaltung v = (Veranstaltung) lv_Veranstaltungen.getItemAtPosition(position);
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("veranstaltung",v);
                i.putExtra("teilnehmer",t);
                startActivity(i);
            }
        });
    }

   /* private void initVariables() {
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
    }*/
}
