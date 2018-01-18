package com.example.oliver.wandertagapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeilnehmerActivity extends AppCompatActivity {
    private ListView lv_Veranstaltungen;
    private MainActivity main = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teilnehmer);

        setListViewItems();
    }

    private void setListViewItems() {
        lv_Veranstaltungen = (ListView) findViewById(R.id.lvVeranstaltungen);
        ArrayAdapter<Veranstaltung> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, main.al_Veranstaltungen);
        lv_Veranstaltungen.setAdapter(adapter);

    }
}
