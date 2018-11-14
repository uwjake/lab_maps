package yama.uwgin.uw.edu.maplab;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng sydney = new LatLng(47.6538, -122.3078);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Look, it's Donald Duck!")
                .icon(BitmapDescriptorFactory.defaultMarker(268))
        );

        PolylineOptions rectOptions = new PolylineOptions();
        rectOptions.add(new LatLng(47.65388, -122.30823),
                new LatLng(47.65362, -122.30789),
                new LatLng(47.65388, -122.30775),
                new LatLng(47.65368, -122.30741),
                new LatLng(47.65397, -122.30730));
        rectOptions.color(getColor(R.color.uwGold));


// Get back the mutable Polygon
        Polyline polyline = mMap.addPolyline(rectOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
