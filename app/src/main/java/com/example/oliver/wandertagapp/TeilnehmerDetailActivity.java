package com.example.oliver.wandertagapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TeilnehmerDetailActivity extends Activity {

    Veranstaltung v;
    Teilnehmer t;
    LocationManager locMan;
    private Location lastLocation = null;
    public static final int RQ_ACCESS_FINE_LOCATION = 666;
    private boolean isGpsAllowed = false;
    private LocationListener listener;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teilnehmer_frag_detail);
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        if (params != null) {
            t = (Teilnehmer) params.get("teilnehmer");
            v = (Veranstaltung) params.get("veranstaltung");
        }
        Button teilnehmenbtn = (Button) findViewById(R.id.teilbtn);
        TextView txver = (TextView) findViewById(R.id.veranstaltungsname);
        txver.setText(v.getBezeichnung());
        TextView txstartDate = (TextView) findViewById(R.id.startdate);
        txstartDate.setText(v.getStartDatum().toString());
        TextView txEndDate = (TextView) findViewById(R.id.enddate);
        txEndDate.setText(v.getEndDatum().toString());
        TextView txort = (TextView) findViewById(R.id.ort);
        txort.setText(v.getOrt());
        TextView txland = (TextView) findViewById(R.id.land);
        txland.setText(v.getLand());
        TextView txbezeichnung = (TextView) findViewById(R.id.bezeichnung);
        txbezeichnung.setText(v.getBezeichnung());
        TextView txvstrasse = (TextView) findViewById(R.id.straße);
        txvstrasse.setText(v.getStrasse());
        TextView telefontxv = (TextView) findViewById(R.id.telefon);
        telefontxv.setText(v.getTelefon());
        TextView emailtxv = (TextView) findViewById(R.id.email);
        emailtxv.setText(v.getEmail());
        tb = (ToggleButton) findViewById(R.id.toggleButton);
    }


    public void teilnehmerdetailbtn(View view)
    {
        if (tb.isChecked() == true) {
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            v.getTeilnehmerList().add(t);
        }
        else
        {
            v.getTeilnehmerList().add(t);
        }
    }
}
