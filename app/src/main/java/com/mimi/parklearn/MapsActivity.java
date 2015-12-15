package com.mimi.parklearn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;   //google maps object that is used to access the Google maps API

    private HashMap<String, DoublePoint> parksLoc;   //Hashmap holding names as keys and a double
    //point object as values containing coords

    private HashMap<String, String> parksInfo;  //A hash map holding the basic information about
    //The parks.

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        parksLoc = new HashMap<String, DoublePoint>();
        parksInfo = new HashMap<String, String>();
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
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        populateMap();
        String curPark = getIntent().getStringExtra("id");

        double tempX, tempY;
        tempX = parksLoc.get(curPark).x;
        tempY = parksLoc.get(curPark).y;

        LatLng thisPark = new LatLng(tempX, tempY);
        com.mimi.parklearn.MapsActivity.CustomInfoWindow newWindow = new CustomInfoWindow();
        mMap.setInfoWindowAdapter(newWindow);
        mMap.moveCamera(CameraUpdateFactory.zoomTo((float) (6.0)));
        mMap.addMarker(new MarkerOptions().position(thisPark)
                .title("This is where " + curPark + " is!")
                .snippet(parksInfo.get(curPark)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(thisPark));
        assert(repOK());

    }

    /**
     * Created by Julien on 12/14/2015.
     */
    private class CustomInfoWindow implements GoogleMap.InfoWindowAdapter {



        CustomInfoWindow(){
        }


        @Override
        public View getInfoWindow(Marker marker) {
            return(null);
        }

        @SuppressLint("InflateParams")
        @Override
        public View getInfoContents(Marker marker) {

            Context context = (MapsActivity.this.getApplicationContext()); //or getActivity(), YourActivity.this, etc.

            LinearLayout info = new LinearLayout(context);
            info.setOrientation(LinearLayout.VERTICAL);

            TextView title = new TextView(context);
            title.setTextColor(Color.BLACK);
            title.setGravity(Gravity.CENTER);
            title.setTypeface(null, Typeface.BOLD);
            title.setText(marker.getTitle());

            TextView snippet = new TextView(context);
            snippet.setTextColor(Color.GRAY);
            snippet.setText(marker.getSnippet());

            info.addView(title);
            info.addView(snippet);

            return info;
        }
    }



    /**
     * This method fills the required hashmaps with relevant information for use in the app
     */
    public void populateMap() {
        assert(repOK());
        parksLoc.put("Rocky Mountain National Park", new DoublePoint(40.342309, -105.686546));
        parksLoc.put("Hot Springs National Park", new DoublePoint(34.531637, -93.061364));
        parksLoc.put("Theodore Roosevelt National Park", new DoublePoint(46.979002, -103.538763));
        parksLoc.put("Crater Lake National Park", new DoublePoint(42.868480, -122.168586));
        parksLoc.put("Wind Cave National Park", new DoublePoint(43.603461, -103.430592));
        parksLoc.put("Big Bend National Park", new DoublePoint(29.127534, -103.242559));
        parksLoc.put("Shenandoah National Park", new DoublePoint(38.292823, -78.679444));
        parksLoc.put("Arches National Park", new DoublePoint(38.733165, -109.592535));
        parksLoc.put("Mount Rainier National Park", new DoublePoint(46.880025, -121.726899));
        parksLoc.put("Great Smoky Mountains National Park", new DoublePoint(35.611817, -83.489481));
        parksLoc.put("Joshua Tree National Park", new DoublePoint(33.873442, -115.901153));
        parksLoc.put("Glacier National Park", new DoublePoint(48.759669, -113.787001));
        parksLoc.put("Mesa Verde National Park", new DoublePoint(37.230984, -108.461812));
        parksLoc.put("Olympic National Park", new DoublePoint(47.969090, -123.498165));
        parksLoc.put("Petrified Forest National Park", new DoublePoint(34.910042, -109.806770));
        parksLoc.put("Acadia National Park", new DoublePoint(44.338610, -68.273420));
        parksLoc.put("Sequoia National Park", new DoublePoint(36.486367, -118.565902));
        parksLoc.put("Zion National Park", new DoublePoint(37.298211, -113.026258));
        parksLoc.put("Everglades National Park", new DoublePoint(25.286606, -80.898672));
        parksLoc.put("Denali National Park", new DoublePoint(63.114815, -151.192434));
        parksLoc.put("Death Valley National Park", new DoublePoint(36.505320, -117.079526));
        parksLoc.put("Yosemite National Park", new DoublePoint(37.865101, -119.538211));
        parksLoc.put("Grand Canyon National Park", new DoublePoint(36.107017, -112.112922));
        parksLoc.put("Hawaii Volcanoes Wilderness", new DoublePoint(19.261131, -155.319710));
        parksLoc.put("Yellowstone National Park", new DoublePoint(44.428024, -110.588391));

        parksInfo.put("Rocky Mountain National Park",
                "Rocky Mountain National Park is a national park located in the Front Range of the Rocky Mountains, " +
                        "in the north-central region of the U.S. state of Colorado");
        parksInfo.put("Hot Springs National Park",
                "Hot Springs National Park is a United States National Park in central Garland County, " +
                        "Arkansas, adjacent to the city of Hot Springs, the county seat.");

        parksInfo.put("Theodore Roosevelt National Park", "Theodore Roosevelt National Park is a United States " +
                "National Park comprising three geographically separated areas of badlands in western North Dakota.");

        parksInfo.put("Crater Lake National Park", "Crater Lake National Park is a United" +
                " States National Park located in southern Oregon.");

        parksInfo.put("Wind Cave National Park", "Wind Cave National Park is a United States " +
                "national park 10 miles (16 km) north of the town of Hot Springs in western South Dakota.");
 
        parksInfo.put("Big Bend National Park", "Big Bend National Park in the U.S. state of Texas has national " +
                "significance as the largest protected area of Chihuahuan " +
                "Desert topography and ecology in the United States.");

        parksInfo.put("Shenandoah National Park","Shenandoah National Park encompasses part of the " +
                "Blue Ridge Mountains in the U.S. state of Virginia. This national park is long and " +
                "narrow, with the broad Shenandoah River and Valley on the west side, and the " +
                "rolling hills of the Virginia Piedmont on the east.");

        parksInfo.put("Arches National Park", "Arches National Park is a US National Park in " +
                "eastern Utah. The park is located on the Colorado River 4 miles (6 km) north of " +
                "Moab, Utah. It is known for containing over 2,000 natural sandstone arches, " +
                "including the world-famous Delicate Arch, in addition to a variety of unique " +
                "geological resources and formations.");

        parksInfo.put("Mount Rainier National Park", "Mount Rainier National Park is a United States" +
                " National Park located in southeast Pierce County and northeast Lewis County in" +
                " Washington state.[3] It was established on March 2, 1899 as the fifth national " +
                "park in the United States. The park encompasses 236,381 acres (369.35 sq mi; 956.60 km2)" +
                " including all of Mount Rainier, a 14,411-foot (4,392 m) stratovolcano");

        parksInfo.put("Great Smoky Mountains National Park", "Great Smoky Mountains National Park " +
                "is a United States National Park and UNESCO World Heritage Site that straddles " +
                "the ridgeline of the Great Smoky Mountains, part of the Blue Ridge Mountains," +
                " which are a division of the larger Appalachian Mountain chain. The border" +
                " between Tennessee and North Carolina runs northeast to southwest through" +
                " the centerline of the park. It is the most visited national park" +
                " in the United States.");

        parksInfo.put("Joshua Tree National Park", "Joshua Tree National Park is " +
                "located in southeastern California. Declared a U.S. National Park in" +
                " 1994 when the U.S. Congress passed the California Desert Protection Act" +
                " (Public Law 103-433), it had previously been a U.S. National" +
                " Monument since 1936.");

        parksInfo.put("Glacier National Park", "Glacier National Park is a national park located" +
                " in the U.S. state of Montana, on the Canada–United States border with the" +
                " Canadian provinces of Alberta and British Columbia. The park encompasses" +
                " over 1 million acres (4,000 km2) and includes parts of two mountain ranges" +
                " (sub-ranges of the Rocky Mountains), over 130 named lakes, more than 1,000" +
                " different species of plants, and hundreds of species of animals.");

        parksInfo.put("Mesa Verde National Park", "Mesa Verde National Park is a National Park and" +
                " World Heritage Site located in Montezuma County, Colorado." +
                " It protects some of the best preserved Ancestral Puebloan archeological" +
                " sites in the United States.");

        parksInfo.put("Olympic National Park", "Olympic National Park is a United States" +
                " national park located in the state of Washington, on the Olympic Peninsula." +
                " The park has four basic regions: the Pacific coastline, alpine areas, " +
                "the west side temperate rainforest and the forests of the drier east side.[4]");

        parksInfo.put("Petrified Forest National Park", "Petrified Forest National Park is" +
                " a United States national park in Navajo and Apache counties in northeastern" +
                " Arizona. Named for its large deposits of petrified wood, the fee area of the" +
                " park covers about 170 square miles (440 square kilometers), encompassing" +
                " semi-desert shrub steppe as well as highly eroded and colorful badlands.");

        parksInfo.put("Acadia National Park", "Acadia National Park is a national park located" +
                " in the U.S. state of Maine. It reserves much of Mount Desert Island, and " +
                "associated smaller islands, off the Atlantic coast. Created as Lafayette" +
                " National Park in 1919, it was renamed Acadia in 1929[3] and is the third " +
                "oldest national park east of the Mississippi River, following Thousand Islands" +
                " (1904) and Point Pelee (1918) in Ontario.");

        parksInfo.put("Sequoia National Park", "Sequoia National Park is a national park in the" +
                " southern Sierra Nevada east of Visalia, California, in the United States. It" +
                " was established on September 25, 1890. The park spans 404,064 acres (631.3" +
                "5 sq mi; 163,518.90 ha; 1,635.19 km2).[1] Encompassing a vertical relief of" +
                " nearly 13,000 feet (4,000 m), the park contains among its natural resources" +
                " the highest point in the contiguous 48 United States, Mount Whitney," +
                " at 14,505 feet (4,421 m) above sea level.");

        parksInfo.put("Zion National Park", "Zion National Park is located in the Southwestern " +
                "United States, near Springdale, Utah. A prominent feature of the 229-square-mile" +
                " (590 km2) park is Zion Canyon, which is 15 miles (24 km) long and up to hal" +
                "f a mile (800 m) deep, cut through the reddish and tan-colored Navajo Sandstone" +
                " by the North Fork of the Virgin River. The lowest elevation is 3,666 ft (1,117 m)" +
                " at Coalpits Wash and the highest elevation is 8,726 ft (2,660 m) at" +
                " Horse Ranch Mountain. Located at the junction of the Colorado Plateau," +
                " Great Basin, and Mojave Desert regions, the park's unique geography and" +
                " variety of life zones allow for unusual plant and animal diversity.");

        parksInfo.put("Everglades National Park", "Everglades National Park is a U.S. National" +
                " Park in Florida that protects the southern 20 percent of the original Everglades." +
                " In the United States, it is the largest tropical wilderness, the largest" +
                " wilderness of any kind east of the Mississippi River, and is visited on" +
                " average by one million people each year.");

        parksInfo.put("Denali National Park", "Denali National Park and Preserve is a national" +
                " park and preserve located in Interior Alaska, centered on Denali, the highest" +
                " mountain in North America. The park and contiguous preserve encompasses more" +
                " than 6 million acres (24,500 km2), of which 4,724,735.16 acres (19,120 km2)" +
                " are federally owned national park. The national preserve is 1,334,200 acres" +
                " (5,430 km2), of which 1,304,132 acres (5,278 km2) are federally owned. On" +
                " December 2, 1980, a 2,146,580 acre (8,687 km2) Denali Wilderness was" +
                " established within the park.");

        parksInfo.put("Death Valley National Park", "Death Valley National Park is a national" +
                " park in the U.S. states of California and Nevada that is located east of" +
                " the Sierra Nevada, occupying an interface zone between the arid Great" +
                " Basin and Mojave deserts in the United States. The park protects the" +
                " northwest corner of the Mojave Desert and contains a diverse desert" +
                " environment of salt-flats, sand dunes, badlands, valleys, canyons," +
                " and mountains. It is the largest national park in the lower 48 states" +
                " and has been declared an International Biosphere Reserve.");

        parksInfo.put("Yosemite National Park", "Yosemite National Park is a United States" +
                " National Park spanning eastern portions of Tuolumne, Mariposa and Madera" +
                " counties in the central eastern portion of the U.S. state of California," +
                " commonly referred to as Northern California. The park, which is" +
                " managed by the National Park Service, covers an area of 747,956 acres" +
                " (1,168.681 sq mi; 302,687 ha; 3,026.87 km2) and reaches" +
                " across the western slopes of the Sierra Nevada mountain chain.");

        parksInfo.put("Grand Canyon National Park", "Grand Canyon National Park is the" +
                " United States' 15th oldest national park. Named a UNESCO " +
                "World Heritage Site in 1979, the park is located in Arizona." +
                " The park's central feature is the Grand Canyon, a gorge of " +
                "the Colorado River, which is often considered one of the Seven " +
                "Natural Wonders of the World. The park covers 1,217,262 acres " +
                "(1,901.972 sq mi; 492,608 ha; 4,926.08 km2) of unincorporated " +
                "area in Coconino and Mohave counties.");

        parksInfo.put("Hawaii Volcanoes Wilderness", "Hawaii Volcanoes Wilderness is a" +
                " designated wilderness area within Hawaii Volcanoes National Park on the" +
                " island of Hawaii in the U.S. state of Hawaii. It was designated in 1978" +
                " with 123,100 acres (498 km2), and was later expanded to 130,790 acres" +
                " (529 km2).[1] Wilderness designation covers the northwestern extension" +
                " of the National Park, including Mokuaweoweo, the summit of the volcano" +
                " Mauna Loa. In the southwestern portion of the park, a large chunk of" +
                " wilderness includes several miles of coastline, a small portion southeast" +
                " of the visitors center, and the ʻOlaʻa Forest, which is separate from and" +
                " just north of the park.");

        parksInfo.put("Yellowstone National Park", "Yellowstone National Park" +
                " a national park located primarily in the U.S. state of Wyoming," +
                " although it also extends into Montana and Idaho. It was established" +
                " by the U.S. Congress and signed into law by President Ulysses S. Grant" +
                " on March 1, 1872.[5][6] Yellowstone, the first National Park in the U.S." +
                " and widely held to be the first national park in the world,[7] is known" +
                " for its wildlife and its many geothermal features, especially Old Faithful" +
                " Geyser, one of the most popular features in the park.[8] It has many types of" +
                " ecosystems, but the subalpine forest is most abundant. It is part of the South" +
                " Central Rockies forests ecoregion.");
        assert(repOK());
    }

    private class DoublePoint {
        public double x;
        public double y;

        public DoublePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean repOK(){
        return parksInfo != null && parksLoc != null;
    }

}
