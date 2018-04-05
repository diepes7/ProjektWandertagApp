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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teilnehmer_detail);
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        if (params != null) {
            t = (Teilnehmer) params.get("teilnehmer");
            v = (Veranstaltung) params.get("veranstaltung");
        }
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_teilnehmer_detail, null);
        resolveIntent(view);
    }

    public void resolveIntent(View view) {

        Button teilnehmenbtn = (Button) view.findViewById(R.id.teilbtn);
        TextView txver = (TextView) view.findViewById(R.id.veranstaltungsname);
        txver.setText(v.getBezeichnung());
        TextView txstartDate = (TextView) view.findViewById(R.id.startdate);
        txstartDate.setText(v.getStartDatum().toString());
        TextView txEndDate = (TextView) view.findViewById(R.id.enddate);
        txEndDate.setText(v.getEndDatum().toString());
        TextView txort = (TextView) view.findViewById(R.id.ort);
        txort.setText(v.getOrt());
        TextView txland = (TextView) view.findViewById(R.id.land);
        txland.setText(v.getLand());
        TextView txbezeichnung = (TextView) view.findViewById(R.id.bezeichnung);
        txbezeichnung.setText(v.getBezeichnung());
        TextView txvstrasse = (TextView) view.findViewById(R.id.straße);
        txvstrasse.setText(v.getStrasse());
        TextView telefontxv = (TextView) view.findViewById(R.id.telefon);
        telefontxv.setText(v.getTelefon());
        TextView emailtxv = (TextView) view.findViewById(R.id.email);
        emailtxv.setText(v.getEmail());
    }

    public void teilnehmerdetailbtn(View view)
    {
        final ToggleButton tb = (ToggleButton) view.findViewById(R.id.toggleButton);
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
            Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            t.setLat(loc.getLatitude());
            t.setLongi(loc.getLongitude());
            v.getTeilnehmerList().add(t);
        }
        else
        {
            v.getTeilnehmerList().add(t);
        }
        Toast.makeText(getApplicationContext(),t.getNachname() + " " + t.getLongi() + " " +t.getLat() ,Toast.LENGTH_SHORT);
    }
    private void registerSystemService() {
        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
        assertPermission();
    }

    private void assertPermission() {
        Toast.makeText(getApplicationContext(), "onMap ready ActivityCompat", Toast.LENGTH_LONG);
        String perm = Manifest.permission.ACCESS_FINE_LOCATION;
        if (ActivityCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{perm}, RQ_ACCESS_FINE_LOCATION);

        } else {
            gpsGranted();
        }
    }

    private void gpsGranted() {
        Toast.makeText(getApplicationContext(), "gpsGranted", Toast.LENGTH_LONG);
        isGpsAllowed = true;
        //showAllProviders();
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Toast.makeText(getApplicationContext(), "onLocationChanged", Toast.LENGTH_LONG);
                LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
                t.setLat(location.getLatitude());
                t.setLongi(location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Toast.makeText(getApplicationContext(), "onStatusChanged", Toast.LENGTH_LONG);
            }

            @Override
            public void onProviderEnabled(String provider) {
                Toast.makeText(getApplicationContext(), "onProviderEnabled", Toast.LENGTH_LONG);
            }

            @Override
            public void onProviderDisabled(String provider) {
                Toast.makeText(getApplicationContext(), "onProviderDisabled", Toast.LENGTH_LONG);
            }
        };
    }
}
