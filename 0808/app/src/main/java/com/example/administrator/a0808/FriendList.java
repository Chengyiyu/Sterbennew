package com.example.administrator.a0808;

import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by SterbenFox on 2017/8/14.
 */

public class FriendList {


    FriendListAdapter adapterItem;
    private Vector<String> placenametemp = new Vector<>();
    private Vector<Double> Ntemp = new Vector<>();
    private Vector<Double> Etemp = new Vector<>();
    public Vector<String> OwnName = new Vector<>();
    JsonFind FindData =new JsonFind();
    JSONArray gi = new JSONArray();
    JSONObject ai =new JSONObject();
    private int FriendsAmount=0;
    public String dd;
    public String[] names = {"成一","仁宏","志偉","育成" , "御浜","祥語","宇可可","松哥","AndyNing","左林"};



    public void getData(JSONObject SQL, boolean[] ListShow){
        for (int x=0;x<names.length;x++) {
            if(ListShow[x]){
            int i=0;
            do {
                JSONObject finalJsonData = FindData.FindData(SQL, x, i);
                try {
                    placenametemp.addElement(finalJsonData.getString("map"));
                    Ntemp.addElement(finalJsonData.getDouble("mapN"));
                    Etemp.addElement(finalJsonData.getDouble("mapE"));
                    OwnName.addElement(names[x]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            } while (FindData.FindData(SQL, x, i) != null);
            }
        }

    }

    public Vector<Double> gettemp(int selection){


        if(selection==0)
            return Ntemp;
        if(selection==1)
            return Etemp;
         else
             return null;

    }
    public Vector<String> getNtmep(int selection){
        if(selection==0)
        return placenametemp;
        if (selection==1)
            return OwnName;
        else
            return null;

    }






}
