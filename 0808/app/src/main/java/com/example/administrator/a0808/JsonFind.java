package com.example.administrator.a0808;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SterbenFox on 2017/7/15.
 */

public class JsonFind {
    private int datacount=0;
    private String[]friendname=new String[]{"成一","仁宏","志偉","育成" , "御浜","祥語","宇可可","松哥","AndyNing","左林"};
    public JSONObject FindData(JSONObject SQL, int friendsNum, int dataNum){
        JSONArray gi = new JSONArray();
        JSONObject ai =new JSONObject();
        JSONObject gogo =new JSONObject();
        JSONObject didd =new JSONObject();
        JSONArray lastee=new JSONArray();
        try {
            gi =SQL.getJSONArray("name");
            ai=gi.getJSONObject(friendsNum);
            didd=ai.getJSONObject(friendname[friendsNum]);
            gogo=didd.getJSONObject("tagged_places");
            lastee=gogo.getJSONArray("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            datacount=lastee.length();
            return lastee.getJSONObject(dataNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
