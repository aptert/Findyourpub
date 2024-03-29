package com.example.tomapter.findyourpub;


/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * This demo shows how GMS Location can be used to check for changes to the users location.  The
 * "My Location" button uses GMS Location to set the blue dot representing the users location.
 * Permission for {@link android.Manifest.permission#ACCESS_FINE_LOCATION} is requested at run
 * time. If the permission has not been granted, the Activity is finished with an error message.
 */
public class FindPubCoventryActivity extends AppCompatActivity implements
        OnMyLocationButtonClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    /**
     * Request code for location permission request.
     *
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    /**
     * Flag indicating whether a requested permission has been denied after returning in
     * {@link #onRequestPermissionsResult(int, String[], int[])}.
     */
    private boolean mPermissionDenied = false;
    private double lat;
    private double lon;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pub);

        lat = MainActivity.lat;
        lon = MainActivity.lon;



        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        MarkerOptions phoenix = new MarkerOptions().position(new LatLng(52.406578,-1.504017));
        phoenix.title("Phoenix").snippet("122 Gosford St, Coventry CV1 5DL, UK");
        MarkerOptions quidsinn = new MarkerOptions().position(new LatLng(52.406594,-1.503214));
        quidsinn.title("Quid's Inn").snippet("117 Gosford St, Coventry CV1 5DL, UK");
        MarkerOptions castleGround = new MarkerOptions().position(new LatLng(52.406594,-1.503214));
        castleGround.title("Castle Ground").snippet("7 Little Park St, Coventry CV1 2UR, UK");
        MarkerOptions establishment = new MarkerOptions().position(new LatLng(52.407773,-1.507803));
        establishment.title("Establishment").snippet("The Old County Hall Bayley Lane, Coventry CV1 5RN, UK");
        MarkerOptions lasIguanas = new MarkerOptions().position(new LatLng(52.407818,-1.510293));
        lasIguanas.title("Las Iguanas").snippet("SU4, Cathedral Lanes Shopping Centre, Broadgate, Coventry CV1 1LL, UK");
        MarkerOptions ivyHouse = new MarkerOptions().position(new LatLng(52.406787,-1.504506));
        ivyHouse.title("Ivy House").snippet("44 Jordans close, Coventry CV1 5RW, UK");
        MarkerOptions aint_nothin = new MarkerOptions().position(new LatLng(51.512965, -0.139525));
        aint_nothin.title("Ain't nothing but...").snippet("20 Kingly St, Carnaby, London W1B 5PZ");
        MarkerOptions albany = new MarkerOptions().position(new LatLng(51.523372, -0.143930));
        albany.title("The Albany").snippet("240 Great Portland St, Paddington, London W1W 5QU");
        MarkerOptions boston = new MarkerOptions().position(new LatLng(51.514697, -0.131257));
        boston.title("68 & Boston").snippet("5 Greek St, Soho, London W1D 4DD");
        MarkerOptions apeandbird = new MarkerOptions().position(new LatLng(51.513383, -0.128761));
        apeandbird.title("Ape & Bird").snippet("142 Shaftesbury Ave, Soho");
        MarkerOptions termini = new MarkerOptions().position(new LatLng(51.513677, -0.129790));
        termini.title("Bar Termini").snippet("7 Old Compton St, Soho");
        MarkerOptions chameleon = new MarkerOptions().position(new LatLng(52.479049,-1.903051));
        chameleon.title("The Chameleon").snippet("1 Victoria Square, Hill St, Birmingham B1 1BD");
        mMap.addMarker(phoenix);
        mMap.addMarker(quidsinn);
        mMap.addMarker(castleGround);
        mMap.addMarker(establishment);
        mMap.addMarker(lasIguanas);
        mMap.addMarker(ivyHouse);
        mMap.addMarker(aint_nothin);
        mMap.addMarker(albany);
        mMap.addMarker(boston);
        mMap.addMarker(apeandbird);
        mMap.addMarker(termini);
        mMap.addMarker(chameleon);

        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();
        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(lat,
                        lon));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(13);

        map.moveCamera(center);
        map.animateCamera(zoom);
    }



    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        //Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

}


