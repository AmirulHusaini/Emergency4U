package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.project.databinding.ActivityMapsBinding;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.0, 101);

        markerOptions = new Vector<>();

        markerOptions.add(marker = new MarkerOptions().title("Hospital Sultanah Bahiyah")
                .position(new LatLng(6.149064, 100.4067648))
                .snippet("Alor Setar, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Hospital Sultanah Bahiyah II")
                .position(new LatLng(6.140672, 100.3722594))
                .snippet("Alor Setar, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Hospital Sultan Abdul Halim")
                .position(new LatLng(5.6704715, 100.5167792))
                .snippet("Sungai Petani, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Hospital Kuala Nerang")
                .position(new LatLng(6.2511891, 100.6097123))
                .snippet("Kuala Nerang, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Hospital Baling")
                .position(new LatLng(5.678734, 100.9252))
                .snippet("Baling, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Hospital Jitra")
                .position(new LatLng(6.278285, 100.4197))
                .snippet("Jitra, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Hospital Sik")
                .position(new LatLng(5.811514, 100.7273))
                .snippet("Sik, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Klinik Kesihatan Gulau")
                .position(new LatLng(6.02782, 100.811))
                .snippet("Sik, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Klinik Kesihatan Kubur Panjang")
                .position(new LatLng(6.08913, 100.5537))
                .snippet("Pendang, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Klinik Kesihatan Naka")
                .position(new LatLng(6.14058, 100.6684))
                .snippet("Kuala Nerang, Kedah")
        );

        markerOptions.add(marker = new MarkerOptions().title("Klinik Kesihatan Pedu")
                .position(new LatLng(6.224971, 100.655))
                .snippet("Kuala Nerang, Kedah")
        );
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation, 8));

        enableMyLocation();
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms, 200);
        }
    }
}