package com.mimi.parklearn;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private HashMap<String, DoublePoint> parks;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        populateMap();
        String curPark = getIntent().getStringExtra("id");

        Log.v("MyActivity", curPark + "   HERE I AM");

        double tempX, tempY;
        tempX = parks.get(curPark).x;
        tempY = parks.get(curPark).y;



        LatLng thisPark = new LatLng(tempX, tempY);
        mMap.addMarker(new MarkerOptions().position(thisPark).title("This is where " + curPark + " is!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(thisPark));
    }

    public void populateMap() {
        parks = new HashMap<String, DoublePoint>();
        parks.put("Rocky Mountain National Park", new DoublePoint(40.342309, -105.686546));
        parks.put("Hot Springs National Park", new DoublePoint(34.531637, -93.061364));
        parks.put("Theodore Roosevelt National Park", new DoublePoint(46.979002, -103.538763));
        parks.put("Crater Lake National Park", new DoublePoint(42.868480, -122.168586));
        parks.put("Wind Cave National Park", new DoublePoint(43.603461, -103.430592));
        parks.put("Big Bend National Park", new DoublePoint(29.127534, -103.242559));
        parks.put("Shenandoah National Park", new DoublePoint(38.292823, -78.679444));
        parks.put("Arches National Park", new DoublePoint(38.733165, -109.592535));
        parks.put("Mount Rainier National Park", new DoublePoint(46.880025, -121.726899));
        parks.put("Great Smoky Mountains National Park", new DoublePoint(35.611817, -83.489481));
        parks.put("Joshua Tree National Park", new DoublePoint(33.873442, -115.901153));
        parks.put("Glacier National Park", new DoublePoint(48.759669, -113.787001));
        parks.put("Mesa Verde National Park", new DoublePoint(37.230984, -108.461812));
        parks.put("Olympic National Park", new DoublePoint(47.969090, -123.498165));
        parks.put("Petrified Forest National Park", new DoublePoint(34.910042, -109.806770));
        parks.put("Acadia National Park", new DoublePoint(44.338610, -68.273420));
        parks.put("Sequoia National Park", new DoublePoint(36.486367, -118.565902));
        parks.put("Zion National Park", new DoublePoint(37.298211, -113.026258));
        parks.put("Everglades National Park", new DoublePoint(25.286606, -80.898672));
        parks.put("Denali National Park", new DoublePoint(63.114815, -151.192434));
        parks.put("Death Valley National Park", new DoublePoint(36.505320, -117.079526));
        parks.put("Yosemite National Park", new DoublePoint(37.865101, -119.538211));
        parks.put("Grand Canyon National Park", new DoublePoint(36.107017, -112.112922));
        parks.put("Hawaii Volcanoes Wilderness", new DoublePoint(19.261131, -155.319710));
        parks.put("Yellowstone National Park", new DoublePoint(44.428024, -110.588391));
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.mimi.parklearn/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.mimi.parklearn/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private class DoublePoint {
        public double x;
        public double y;

        public DoublePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

}
