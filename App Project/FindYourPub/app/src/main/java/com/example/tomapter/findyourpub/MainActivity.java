package com.example.tomapter.findyourpub;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomapter.findyourpub.content.PubContent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.location.LocationServices;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private LocationManager locationManager;
    private LocationListener locationListener;
    private TextView textview;
    private Button find_me;
    private Button go;
    static public double lat;
    static public double lon;
    private static String city;
    private RequestQueue requestQueue;
    private Location mLastLocation;
static public int xx;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView loginLink= (ImageView) findViewById(R.id.loginLink);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        find_me = (Button) findViewById(R.id.find_me);
        go = (Button) findViewById(R.id.go);
        textview = (TextView) findViewById(R.id.fieldCity);
        requestQueue = Volley.newRequestQueue(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        /*if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) { //Uncomment this block to make it work on real device
            mLastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            mLastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        }

        lon = mLastLocation.getLongitude();
        lat = mLastLocation.getLatitude();*/ //Till there
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                lon = location.getLongitude();
                lat = location.getLatitude();


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        //passing the data to PubListActivity using bundle because of double values

        Bundle bundle = new Bundle();
        Intent intent = new Intent(getBaseContext(), PubListActivity.class);
        bundle.putDouble("lat", lat);
        bundle.putDouble("lon", lon);
        intent.putExtras(bundle);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 10);
        } else {
            locationManager.requestLocationUpdates("gps", 0, 0, locationListener); //Why is it taking so long?
            configureButton();
        }




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    if (lat == 0.00 && lon == 0.00){
                        Log.d("test", "coordinates are not valid");
                    }
                    else{
                        Log.d("test", "coordinates are valid");
                    }
                    configureButton();

        }
    }

    private void configureButton() {
        find_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Location", "requestLocationUpdates activated");
                Log.d("lat lon", Double.toString(lat) +" "+ Double.toString(lon));


                if(lat != 0.00 && lon != 0.00){
                    go.setEnabled(true);
                    JsonObjectRequest request = new JsonObjectRequest("https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key=AIzaSyDdoP5TUpFJsKV44HVVocmU9C2JzLduDy0", new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("request", "request got a response!");

                            String address = null;
                            try {
                                address = response.getJSONArray("results").getJSONObject(1).getString("formatted_address");
                                city = response.getJSONArray("results").getJSONObject(1).getJSONArray("address_components").getJSONObject(2).getString("long_name");
                                Intent intent = new Intent(getBaseContext(),PubContent.class);
                                intent.putExtra("city", city);
                                textview.setText(" ");
                                textview.setText("You are in " + address);
                                Log.d("address", "been there");
                                Log.d("city", city);
                                Log.d("address", response.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

                    requestQueue.add(request);
                }

            }
        });
    }

    public void onClick(View v){
        switch (v.getId()){
            /*case R.id.find_me:

                //ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                //startActivity(new Intent(this, FindPubActivity.class));

                break;*/
            case R.id.go:
                startActivity(new Intent(this, PubListActivity.class));
                break;
        }
    }

    public static String getCity() {
        return city;
    }

}
