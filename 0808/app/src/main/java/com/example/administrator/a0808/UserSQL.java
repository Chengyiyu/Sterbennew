package com.example.administrator.a0808;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SterbenFox on 2017/7/15.
 */

public class UserSQL {
    private static String[] names = {"成一","仁宏","志偉","育成" , "御浜","祥語","宇可可","松哥","AndyNing","左林"};
    private static String[] map1= {"Tama Tama /慢食堂" , "里吉拿" , "晨間廚房德明店" , "Pizza Rock 中港店" , "多多茶坊" , "小判" , "核桃屋"};
    private static String[] map2 = {"泰萌泰式風味小館" , "Pizza Rock 中港店" , "多多茶坊" , "雙醬咖哩" , "大台北阿松的店" , "小判" , "核桃屋"};
    private static String[] map3 = {"豐FOOD-海陸百匯", "里吉拿" ,"晨間廚房德明店" , "Pizza Rock 中港店" , "多多茶坊" , "小判" , "核桃屋"};
    private static String[] map4 = {"漁都日式料理" , "里吉拿" , "小判" , "核桃屋" , "歐尼の料理廚房" , "蘿西媽媽漢堡" , "雙醬咖哩"};
    private static String[] map5 = {"泰萌泰式風味小館" , "核桃屋" , "Pizza Rock 中港店" , "多多茶坊" , "里吉拿" , "大台北阿松的店" , "小李子北方麵食館"};
    private static String[] map6 = {"The Toast Heaven" , "雙醬咖哩" , "Pizza Rock 中港店" , "多多茶坊" , "小李子北方麵食館" , "鼎珍香小火鍋" , "五味臭臭鍋" };
    private static String[] map7 = {"泰萌泰式風味小館" , "雙醬咖哩" , "鼎珍香小火鍋" , "小李子北方麵食館" , "核桃屋" , "雙醬咖哩" , "晨間廚房德明店"};
    private static String[] map8 = {"核桃屋" , "晨間廚房德明店" , "Omaya春川炒雞-桃園春日店" , "小李子北方麵食館" , "泰萌泰式風味小館" , "雙醬咖哩" , "五味臭臭鍋"};
    private static String[] map9 = {"核桃屋" , "花田牧場日式壽喜燒-桃園店" , "泰萌泰式風味小館" , "品客牛排" , "小阿姨義麵屋 Aunty Pasta" , "vivi 鄉村 早午餐" , "蘿西媽媽漢堡"};
    private static String[] map10 = {"核桃屋" , "羅媽媽牛肉麵鍋燒麵桃銘店" , "上禾味永和豆漿-銘傳店" , "鼎贊牛排館" , "粑粑絲 - 雲南傳統小吃" , "泰萌泰式風味小館" , "里吉拿"};

    private static double[] dMapN1 = {24.99966 , 24.98824 , 24.98876 , 24.18066 , 24.14874 , 24.98974 , 24.98949};
    private static double[] dMapN2 = {24.98914 , 24.18066 , 24.14874 , 24.98830 , 24.98933 , 24.98974 , 24.98949};
    private static double[] dMapN3 = {25.08383 , 24.98824 , 24.98876 , 24.18066 , 24.14874 , 24.98974 , 24.98949};
    private static double[] dMapN4 = {24.99164 , 24.98824 , 24.98974 , 24.98949 , 24.98827 , 24.98827 , 24.98830};
    private static double[] dMapN5 = {24.98914 , 24.98949 , 24.18066 , 24.14874 , 24.98824 , 24.98933 , 24.98401};
    private static double[] dMapN6 = {25.02032 , 24.98830 , 24.18066 , 24.14874 , 24.98401 , 24.98924 , 24.98895};
    private static double[] dMapN7 = {24.98914 , 24.98830 , 24.98924 , 24.98401 , 24.98949 , 24.98830 , 24.98876};
    private static double[] dMapN8 = {24.98949 , 24.98876 , 25.00983 , 24.98401 , 24.99164 , 24.98830 , 24.98895};
    private static double[] dMapN9 = {24.98949 , 24.98914 , 25.00983 , 24.96195 , 24.99342 , 24.98941 , 24.98827};
    private static double[] dMapN10= {24.98949 , 24.98875 , 24.99434 , 25.00479 , 24.99237 , 24.99164 , 24.98824};

    private static double[] dMapE1 = {121.31478 , 121.34375 , 121.34342 , 120.62039 , 120.68579 , 121.34349 , 121.34404};
    private static double[] dMapE2 = {121.34445 , 120.62039 , 120.68579 , 121.34348 , 121.34436 , 121.34349 , 121.34404};
    private static double[] dMapE3 = {121.55461 , 121.34375 , 121.34342 , 120.62039 , 120.68579 , 121.34349 , 121.34404};
    private static double[] dMapE4 = {121.34375 , 121.34375 , 121.34349 , 121.34404 , 121.34371 , 121.34361 , 121.34348};
    private static double[] dMapE5 = {121.34445 , 121.34404 , 120.62039 , 120.68579 , 121.34375 , 121.34436 , 121.34371};
    private static double[] dMapE6 = {121.46908 , 121.34348 , 120.62039 , 120.68579 , 121.34346 , 121.34435 , 121.34395};
    private static double[] dMapE7 = {121.34445 , 121.34348 , 121.34435 , 121.34371 , 121.34404 , 121.34348 , 121.34342};
    private static double[] dMapE8 = {121.34404 , 121.34342 , 121.31105 , 121.34371 , 121.34375 , 121.34348 , 121.34395};
    private static double[] dMapE9 = {121.34404 , 121.34445 , 121.31105 , 121.22378 , 121.34161 , 121.34555 , 121.34361};
    private static double[] dMapE10= {121.34404 , 121.34347 , 121.34144 , 121.30476 , 121.34046 , 121.34375 , 121.34375};

    public static JSONObject jsonFriendsData =new JSONObject();



    public UserSQL() throws JSONException {
        JSONObject namejson1 =new JSONObject();
        JSONObject namejson2 =new JSONObject();
        JSONObject namejson3 =new JSONObject();
        JSONObject namejson4 =new JSONObject();
        JSONObject namejson5 =new JSONObject();
        JSONObject namejson6 =new JSONObject();
        JSONObject namejson7 =new JSONObject();
        JSONObject namejson8 =new JSONObject();
        JSONObject namejson9 =new JSONObject();
        JSONObject namejson10 =new JSONObject();


        JSONArray lastarry =new JSONArray();

        JSONObject tagged_places1=new JSONObject();
        JSONObject friendname1=new JSONObject();
        JSONArray namedata1 =new JSONArray();
        JSONObject tagged_places2=new JSONObject();
        JSONObject friendname2=new JSONObject();
        JSONArray namedata2 =new JSONArray();
        JSONObject tagged_places3=new JSONObject();
        JSONObject friendname3=new JSONObject();
        JSONArray namedata3 =new JSONArray();
        JSONObject tagged_places4=new JSONObject();
        JSONObject friendname4=new JSONObject();
        JSONArray namedata4 =new JSONArray();
        JSONObject tagged_places5=new JSONObject();
        JSONObject friendname5=new JSONObject();
        JSONArray namedata5 =new JSONArray();
        JSONObject tagged_places6=new JSONObject();
        JSONObject friendname6=new JSONObject();
        JSONArray namedata6 =new JSONArray();
        JSONObject tagged_places7=new JSONObject();
        JSONObject friendname7=new JSONObject();
        JSONArray namedata7 =new JSONArray();
        JSONObject tagged_places8=new JSONObject();
        JSONObject friendname8=new JSONObject();
        JSONArray namedata8 =new JSONArray();
        JSONObject tagged_places9=new JSONObject();
        JSONObject friendname9=new JSONObject();
        JSONArray namedata9 =new JSONArray();
        JSONObject tagged_places10=new JSONObject();
        JSONObject friendname10=new JSONObject();
        JSONArray namedata10 =new JSONArray();


        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map1[i]);
            mapjson.put("mapN",dMapN1[i]);
            mapjson.put("mapE",dMapE1[i]);
            namedata1.put(mapjson);
        }
        friendname1.put("data",namedata1);
        tagged_places1.put("tagged_places",friendname1);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map2[i]);
            mapjson.put("mapN",dMapN2[i]);
            mapjson.put("mapE",dMapE2[i]);
            namedata2.put(mapjson);
        }
        friendname2.put("data",namedata2);
        tagged_places2.put("tagged_places",friendname2);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map3[i]);
            mapjson.put("mapN",dMapN3[i]);
            mapjson.put("mapE",dMapE3[i]);
            namedata3.put(mapjson);
        }
        friendname3.put("data",namedata3);
        tagged_places3.put("tagged_places",friendname3);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map4[i]);
            mapjson.put("mapN",dMapN4[i]);
            mapjson.put("mapE",dMapE4[i]);
            namedata4.put(mapjson);
        }
        friendname4.put("data",namedata4);
        tagged_places4.put("tagged_places",friendname4);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map5[i]);
            mapjson.put("mapN",dMapN5[i]);
            mapjson.put("mapE",dMapE5[i]);
            namedata5.put(mapjson);
        }
        friendname5.put("data",namedata5);
        tagged_places5.put("tagged_places",friendname5);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map6[i]);
            mapjson.put("mapN",dMapN6[i]);
            mapjson.put("mapE",dMapE6[i]);
            namedata6.put(mapjson);
        }
        friendname6.put("data",namedata6);
        tagged_places6.put("tagged_places",friendname6);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map7[i]);
            mapjson.put("mapN",dMapN7[i]);
            mapjson.put("mapE",dMapE7[i]);
            namedata7.put(mapjson);
        }
        friendname7.put("data",namedata7);
        tagged_places7.put("tagged_places",friendname7);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map8[i]);
            mapjson.put("mapN",dMapN8[i]);
            mapjson.put("mapE",dMapE8[i]);
            namedata8.put(mapjson);
        }
        friendname8.put("data",namedata8);
        tagged_places8.put("tagged_places",friendname8);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map9[i]);
            mapjson.put("mapN",dMapN9[i]);
            mapjson.put("mapE",dMapE9[i]);
            namedata9.put(mapjson);
        }
        friendname9.put("data",namedata9);
        tagged_places9.put("tagged_places",friendname9);

        for(int i=0;i<7;i++){
            JSONObject mapjson=new JSONObject();

            mapjson.put("map",map10[i]);
            mapjson.put("mapN",dMapN10[i]);
            mapjson.put("mapE",dMapE10[i]);
            namedata10.put(mapjson);
        }
        friendname10.put("data",namedata10);
        tagged_places10.put("tagged_places",friendname10);


        namejson1.put(names[0],tagged_places1);
        namejson2.put(names[1],tagged_places2);
        namejson3.put(names[2],tagged_places3);
        namejson4.put(names[3],tagged_places4);
        namejson5.put(names[4],tagged_places5);
        namejson6.put(names[5],tagged_places6);
        namejson7.put(names[6],tagged_places7);
        namejson8.put(names[7],tagged_places8);
        namejson9.put(names[8],tagged_places9);
        namejson10.put(names[9],tagged_places10);

        lastarry.put(namejson1);
        lastarry.put(namejson2);
        lastarry.put(namejson3);
        lastarry.put(namejson4);
        lastarry.put(namejson5);
        lastarry.put(namejson6);
        lastarry.put(namejson7);
        lastarry.put(namejson8);
        lastarry.put(namejson9);
        lastarry.put(namejson10);
        jsonFriendsData.put("name",lastarry);
    };
}
