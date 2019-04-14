package vn.edu.tdtu.lab10.ex2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.tdtu.lab10.R;

/**
 * Created by thChung on 4/13/2019.
 */

public class Exercise2 extends AppCompatActivity implements LocationListener {

    Button btnCheckGpsStatus;
    TextView txtGpsStatus;
    Context context;
    LocationManager locationManager;
    boolean GpsStatus;
    private TextView txtLatitude;
    private TextView txtLongitude;
    public static final int requestPermissionCode = 1;
    private Button btnEnable;
    private Button btnUpdate;
    Location location;
    private String lastKnownLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex2_activity_main);

        btnCheckGpsStatus = (Button) findViewById(R.id.btnCheckGpsStatus);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnEnable = (Button) findViewById(R.id.btnEnable);
        txtGpsStatus = (TextView) findViewById(R.id.txtGpsStatus);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);

        context = getApplicationContext();

        enableRuntimePermission();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        lastKnownLocation = locationManager.getBestProvider(criteria, false);

        CheckGpsStatus();

        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gpsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(gpsIntent);
            }
        });

        btnCheckGpsStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckGpsStatus();
                if (GpsStatus) {
                    txtGpsStatus.setText("Location Services Is Enabled");
                } else {
                    txtGpsStatus.setText("Location Services Is Disabled");
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckGpsStatus();
                if (GpsStatus) {
                    if (ActivityCompat.checkSelfPermission(
                            Exercise2.this,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            &&
                            ActivityCompat.checkSelfPermission(Exercise2.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                    != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    location = locationManager.getLastKnownLocation(lastKnownLocation);
                    locationManager.requestLocationUpdates(lastKnownLocation, 12000, 7, Exercise2.this);

                } else {
                    Toast.makeText(Exercise2.this, "Please Enable GPS First", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void enableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(Exercise2.this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(Exercise2.this, "ACCESS_FINE_LOCATION permission allows us to Access GPS in app", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(Exercise2.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION}, requestPermissionCode);

        }
    }

    public void CheckGpsStatus() {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(Location location) {
        txtLongitude.setText("Longitude:" + location.getLongitude());
        txtLatitude.setText("Latitude:" + location.getLatitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
        switch (RC) {
            case requestPermissionCode:
                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Exercise2.this, "Permission Granted, Now your application can access GPS.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Exercise2.this, "Permission Canceled, Now your application cannot access GPS.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}