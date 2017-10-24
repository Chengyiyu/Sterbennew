package com.example.administrator.a0808;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static com.example.administrator.a0808.R.layout.activity_maps;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener
    {



    private GoogleMap mMap;
    private static final int REQUEST_LOCATION = 2;


    boolean[] FlistShow;
    private Button inputButton;
    UserSQL freinds= new UserSQL();
    FriendList  FList=new FriendList();
    TextView TestView;
    private String dd;

    ListView listView;
    DealHotSpot DealHotS=new DealHotSpot() ;
    List<String> list;

    SharedPreferences settings;
    private Toolbar mtoolbar;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigation_view;
    private DrawerLayout drawerlayout;
    private Vector<String> placenametemp = new Vector<>();
    private Vector<Double> Ntemp = new Vector<>();
    private Vector<Double> Etemp = new Vector<>();
    private Vector<String>OwnName =new Vector<>();
    private Vector<Integer>CheckedFriendslist =new Vector<>();

    private CharSequence mTitle;

    private boolean bStart = true;

    private int PROXIMITY_RADIUS = 1000;

    private static final String ACTIVITY_TAG="LogDemo";


    public MapsActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_maps);

        mtoolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        drawerlayout =(DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle=new ActionBarDrawerToggle(this,drawerlayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = this.getIntent();
        FlistShow=intent.getBooleanArrayExtra("FriendsCheck");




        FList.getData(freinds.jsonFriendsData,FlistShow);
        Ntemp=FList.gettemp(0);
        Etemp=FList.gettemp(1);
        placenametemp = FList.getNtmep(0);
        OwnName =FList.getNtmep(1);
        settings=getSharedPreferences("PREFS",0);
        list = new ArrayList<String>();

        list=intent.getStringArrayListExtra("Grouplist");

        int iLong = placenametemp.size();

        for (int i = 0 ; i < iLong ; i++)
            DealHotS.inputData(placenametemp.get(i) , Ntemp.get(i) , Etemp.get(i) , OwnName.get(i));

        listView=(ListView)findViewById(R.id.Mapfriendmenu);
        FriendListAdapter adapterItem = new FriendListAdapter(this, list);
        listView.setAdapter(adapterItem);

        inputButton = (Button) findViewById(R.id.button2);
        inputButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mMap.clear();
                String url = getUrl(24.985144, 121.344205, "restaurant");
                Object[] DataTransfer = new Object[2];
                DataTransfer[0] = mMap;
                DataTransfer[1] = url;


                GetNearby getNearby = new GetNearby();
                getNearby.execute(DataTransfer);
            }
        });




    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    setupMyLocation();
                }
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
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
        else
        {
            setupMyLocation();
        }
        // Add a marker in Sydney and move the camera

        float zoom = 15;
        LatLng start = new LatLng(24.985144, 121.344205);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(start ));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start , zoom));
        //inputdata();
    }
    private void inputdata(){
        int iLong = placenametemp.size();

        for (int i = 0 ; i < iLong ; i++)
            DealHotS.inputData(placenametemp.get(i) , Ntemp.get(i) , Etemp.get(i) , OwnName.get(i));
        iLong = DealHotS.HotSpot.size();
        for (int i = 0 ; i < iLong ; i++)
        {
            DealHotS.ProductHotSpot(mMap , iLong);
        }
    }

    private void setupMyLocation() {
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public  boolean onMyLocationButtonClick(){
                return false;
            }
        });
    }

    public void inputToMap() {

    }
    @Override
    public void onLocationChanged(Location location) {

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
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){//當按下左上三條線或顯示工具列
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void LoadSetting(){
        String listString =settings.getString("list","");
        String[] itemlists= listString.split(",");
        for(int i=0;i<itemlists.length;i++){
            list.add(itemlists[i]);

        }
        list.remove("");


    }
    private String getUrl(double latitude, double longitude, String nearbyPlace) {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        //中心點設定
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        //半徑設定
        googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS);
        googlePlacesUrl.append("&type=" + nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyATuUiZUkEc_UgHuqsBJa1oqaODI-3mLs0");
        return (googlePlacesUrl.toString());
    }

}
