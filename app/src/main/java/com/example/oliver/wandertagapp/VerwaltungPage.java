package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerwaltungPage extends AppCompatActivity {

    private Button button;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_entwurf);

        initButtonOnClick();
    }

    private void initButtonOnClick() {
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), VeranstaltungErstellen.class);
                startActivity(intent);
            }
        });

        button = null;
        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Verastaltung_bearbeiten_loeschen.class);
                startActivity(intent);
            }
        });

        button = null;
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), OrganisatorErstellen.class);
                startActivity(intent);
            }
        });

        button = null;
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Organisator_bearbeiten_loeschen.class);
                startActivity(intent);
            }
        });

        button = null;
        button = (Button) findViewById(R.id.button33);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), TeilnehmerErstellen.class);
                startActivity(intent);
            }
        });

        button = null;
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Teilnehmer_bearbeiten_loeschen.class);
                startActivity(intent);
            }
        });

        button = null;
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
