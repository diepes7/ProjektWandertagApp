package com.example.oliver.wandertagapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Verastaltung_bearbeiten_loeschen extends AppCompatActivity {

    ListView lvVeranstaltungen;
    EditText etBezeichnung;
    EditText etStartDatum;
    EditText etEndDatum;
    EditText etArt;
    EditText etBemerkung;
    EditText etVeranstalter;
    EditText etStrasse;
    EditText etOrt;
    EditText etLand;
    EditText etTelefon;
    EditText etEmail;
    CheckBox cbAktiv;
    Button btnSpeichern;

    private MainActivity main = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_veranstaltung_bearbeiten_loeschen);
        setLvVeranstaltungen();

    }

    private void setLvVeranstaltungen() {
        setLvAdapter();
                lvVeranstaltungen.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemAt = i;

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Verastaltung_bearbeiten_loeschen.this);
                // ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.alert_layout, null);
                dialogBuilder.setView(dialogView);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                Button btnLoeschen = (Button) dialogView.findViewById(R.id.buttonLoeschen);
                Button btnBearbeiten = (Button) dialogView.findViewById(R.id.buttonBearbeiten);



                btnLoeschen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (main.al_Veranstaltungen.size()>0) {
                            main.al_Veranstaltungen.remove(lvVeranstaltungen.getItemAtPosition(itemAt));
                            setLvVeranstaltungen();
                            alertDialog.dismiss();
                        }
                    }
                });

                btnBearbeiten.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(Verastaltung_bearbeiten_loeschen.this);
                        // ...Irrelevant code for customizing the buttons and title
                        LayoutInflater inflater = getLayoutInflater();
                        View v = inflater.inflate(R.layout.alert_bearbeiten, null);
                        dialog.setView(v);

                        final AlertDialog alert = dialog.create();
                        alertDialog.dismiss();
                        alert.show();

                        initVariables(v);
                        Veranstaltung veranstaltung = (Veranstaltung) lvVeranstaltungen.getItemAtPosition(itemAt);
                        etBezeichnung.setText(veranstaltung.getBezeichnung());
                        etStartDatum.setText(veranstaltung.getStartDatum().toString());
                        etEndDatum.setText(veranstaltung.getEndDatum().toString());
                        etArt.setText(veranstaltung.getArt_Veranstaltung());
                        etBemerkung.setText(veranstaltung.getBemerkung());
                        etVeranstalter.setText(veranstaltung.getVeranstalter());
                        etStrasse.setText(veranstaltung.getStrasse()+ "");
                        etOrt.setText(veranstaltung.getOrt());
                        etLand.setText(veranstaltung.getLand());
                        etTelefon.setText(veranstaltung.getTelefon());
                        etEmail.setText(veranstaltung.getEmail());
                        cbAktiv.setChecked(veranstaltung.isAktiv());
                    }
                });
                return true;
            }
        });

    }

    public void initVariables(View dialogView){
        etBezeichnung = (EditText) dialogView.findViewById(R.id.editTextBezeichnung);
        etStartDatum = (EditText) dialogView.findViewById(R.id.editTextStartDatum);
        etEndDatum = (EditText) dialogView.findViewById(R.id.editTextEndDatum);
        etArt = (EditText) dialogView.findViewById(R.id.editTextArt);
        etBemerkung = (EditText) dialogView.findViewById(R.id.editTextBemerkung);
        etVeranstalter = (EditText) dialogView.findViewById(R.id.editTextVeranstalter);
        etStrasse = (EditText) dialogView.findViewById(R.id.editTextStrasse);
        etOrt = (EditText) dialogView.findViewById(R.id.editTextOrt);
        etLand = (EditText) dialogView.findViewById(R.id.editTextLand);
        etTelefon = (EditText) dialogView.findViewById(R.id.editTextTelefon);
        etEmail = (EditText) dialogView.findViewById(R.id.editTextEmail);
        cbAktiv = (CheckBox) dialogView.findViewById(R.id.checkBoxAktiv);
        btnSpeichern = (Button) dialogView.findViewById(R.id.buttonSpeichern);
    }

    private void setLvAdapter() {
        lvVeranstaltungen = (ListView) findViewById(R.id.lvVeranstaltungen);
        ArrayAdapter<Veranstaltung> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, main.al_Veranstaltungen);
        lvVeranstaltungen.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),AdminPage.class);
        startActivity(i);
    }
}
