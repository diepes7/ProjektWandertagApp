package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
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
    private Button startTracking,attandanceCheck;
    private MainActivity mainActivity;
    Teilnehmer t;
    int indexofatt;

    Veranstaltung v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisator_page);

        initVariables();
        setLvVeranstaltungItems();
        registerForContextMenu(lvTeilnehmer);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.listViewTeilnehmer)
        {
            ListView lv = (ListView)v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo)menuInfo;
            Teilnehmer te = (Teilnehmer) lv.getItemAtPosition(acmi.position);
            indexofatt = acmi.position;
            menu.add("Anwesend");
            menu.add("Abwesend");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("Anwesend"))
        {
            int teil = (int) lvTeilnehmer.getItemIdAtPosition(indexofatt);
            lvTeilnehmer.getChildAt(teil).setBackgroundColor(Color.GREEN);
        }
        if(item.getTitle().equals("Abwesend"))
        {
            lvTeilnehmer.getChildAt(indexofatt).setBackgroundColor(Color.RED);
        }
        return super.onContextItemSelected(item);
    }

    private void initVariables() {
        lvVeranstaltungen = (ListView) findViewById(R.id.listViewVeranstaltungen);
        lvTeilnehmer = (ListView) findViewById(R.id.listViewTeilnehmer);
        startTracking = (Button) findViewById(R.id.buttonStartTracking);
        attandanceCheck =(Button)findViewById(R.id.buttonAttandanceCheck);
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
                v = (Veranstaltung) lvVeranstaltungen.getItemAtPosition(i);
                setLvTeilnehmerItems(v.getTeilnehmerList());
            }
        });

        attandanceCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setLvTeilnehmerItems(List<Teilnehmer> teinehmer) {
        ArrayAdapter<Teilnehmer> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, teinehmer);
        lvTeilnehmer.setAdapter(adapter);

        lvTeilnehmer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t= (Teilnehmer) lvTeilnehmer.getItemAtPosition(position);
            }
        });
        registerForContextMenu(lvVeranstaltungen);
    }

    private void showMapView() {
        Intent i = new Intent(getApplicationContext(),MapsActivity.class);
        i.putExtra("veranstaltung",v);
        i.putExtra("teilnehmer",t);
        startActivity(i);
    }

    private void setLvVeranstaltungItems() {
        ArrayAdapter<Veranstaltung> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, mainActivity.al_Veranstaltungen);
        lvVeranstaltungen.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
    }
}
