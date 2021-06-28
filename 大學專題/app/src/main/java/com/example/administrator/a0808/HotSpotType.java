package com.example.administrator.a0808;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/14.
 */

public class HotSpotType
{
    double dE , dW;
    String sSpotName;
    Set<String> WhoCheckin = new HashSet<>();
    int iCount;

    public HotSpotType(String sName , double dLongitude , double dLatitude , String UserName)
    {
        this.sSpotName = sName;
        this.dE = dLongitude;
        this.dW = dLatitude;
        WhoCheckin.add(UserName);
        this.iCount = 1;
    }
    void  CountPlus()
    {
        this.iCount++;
    }
}
