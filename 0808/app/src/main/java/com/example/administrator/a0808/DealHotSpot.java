package com.example.administrator.a0808;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

/**
 * Created by ZiZiHo on 2017/7/14.
 */

public class DealHotSpot
{
    double dTypeW , dTypeE;
    String sTypeName;
    int iPoepleSum;

    private GoogleMap HotMap;
    Vector<HotSpotType> HotSpot = new Vector();
    int iLong = HotSpot.size();
    LatLng tempSite;

    public void inputData (String sName , double dLongitude , double dLatitude , String UserName)
    {
        HotSpotType temp;
        temp = new HotSpotType(sName , dLongitude , dLatitude , UserName);
        boolean bReapeat = false;

        iLong = HotSpot.size();
        for (int i = 0 ; i < iLong ; i++)
        {
            if ( (dLongitude == HotSpot.get(i).dE && dLatitude == HotSpot.get(i).dW) || HotSpot.get(i).sSpotName == sName )
            {
                if (!HotSpot.get(i).WhoCheckin.contains(UserName))
                {
                    HotSpot.get(i).CountPlus();
                }
                bReapeat = true;
            }

        }
        if (bReapeat == false)
        {
            HotSpot.addElement(temp);
        }
    }
    public void ProductHotSpot(GoogleMap mMap , int iPeople)
    {
        float hue ;
        float rate = iPeople * 1 / 360;
        //hue = HotSpot.get(i).iCount * 90 - 1;  color
        iLong = HotSpot.size();
        for (int i = 0 ; i < iLong ; i++)
        {
            tempSite = new LatLng(HotSpot.get(i).dE , HotSpot.get(i).dW);
            mMap.addMarker(new MarkerOptions()
                    .position(tempSite)
                    .title(HotSpot.get(i).sSpotName)
                    .icon(BitmapDescriptorFactory.defaultMarker( 360 * HotSpot.get(i).iCount / iPeople ))
            );

        }
    }
}
