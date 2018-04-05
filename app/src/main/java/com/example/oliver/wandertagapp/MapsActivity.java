package com.example.oliver.wandertagapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Teilnehmer t;
    Veranstaltung v;
    private Location lastLocation = null;
    public static final int RQ_ACCESS_FINE_LOCATION = 666;
    private boolean isGpsAllowed = false;
    private LocationListener listener;
    private LocationManager locMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        InitIntent();
        registerSystemService();
        /*LocationManager locationManager;
        locationManager = (LocationManager) getApplicationContext().getSystemService(getApplicationContext().LOCATION_SERVICE);
        */
        /*locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, mLocationListener);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        mLocationListener.onLocationChanged(location);*/
    }

    private void InitIntent() {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        if (params != null) {
            t = (Teilnehmer) params.get("teilnehmer");
            v = (Veranstaltung) params.get("veranstaltung");
        }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != RQ_ACCESS_FINE_LOCATION) return;
        ;
        if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Permission for Acess_Fine_Location denied", Toast.LENGTH_LONG);
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
                mMap.addMarker(new MarkerOptions().position(loc).title("Marker"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16));
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

    @SuppressLint("MissingPermission")
    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG);
        super.onResume();
        if (!isGpsAllowed) return;
        locMan = (LocationManager)getSystemService(getApplicationContext().LOCATION_SERVICE);
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, listener);
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG);
        super.onPause();
        if (isGpsAllowed) locMan.removeUpdates(listener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(getApplicationContext(), "onMap ready ActivityCompat", Toast.LENGTH_LONG);
        mMap = googleMap;
        initMap();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
        LatLng latlng = new LatLng(loc.getLatitude(),loc.getLongitude());
        mMap.addMarker(new MarkerOptions().position(latlng).title(t.getVorname()+" "+t.getNachname()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,16));
        locMan = (LocationManager)getSystemService(getApplicationContext().LOCATION_SERVICE);
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, listener);
    }

    private void  initMap()
    {
        try
        {
            mMap.setMyLocationEnabled(true);
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            mMap.getUiSettings().setZoomControlsEnabled(false);
            Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            LatLng latlng = new LatLng(loc.getLatitude(),loc.getLongitude());
            float zoom = 14;
            mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(latlng,zoom)));
        }catch (SecurityException exc)
        {
            Toast.makeText(getApplicationContext(),exc.toString() , Toast.LENGTH_LONG);
        }
    }
}

