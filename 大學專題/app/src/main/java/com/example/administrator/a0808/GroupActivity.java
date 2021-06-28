package com.example.administrator.a0808;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.appevents.AppEventsLogger;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class GroupActivity extends AppCompatActivity {

    List<String> list;
    List<Boolean> listShow;
    List<String> CGrouplist;
    ListView listview;
    private Button addGroup;
    private Button EnterGroup;
    private Button DecGroup;
    SharedPreferences settings;
    boolean[] FlistShow;
    FileOutputStream out = null;
    private static String[] names = {"成一","仁宏","志偉","育成","御浜","祥語","宇可可","松哥","AndyNing","左林"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        File cacheDir =getCacheDir();


        listview = (ListView) findViewById(R.id.GroupListSetting);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                                CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1);
                                                chkItem.setChecked(!chkItem.isChecked());
                                                Toast.makeText(GroupActivity.this, "您點選了 " + settings.getString(list.get(position),""), Toast.LENGTH_SHORT).show();
                                                listShow.set(position, chkItem.isChecked());
                                            }



                                        }
        );

        final Intent intent = this.getIntent();
        list = new ArrayList<String>();

        listShow = new ArrayList<Boolean>();
         settings=getSharedPreferences("PREFS",0);
        LoadGroup();
        if(intent.getStringExtra("Groupname")!=null)
            list.add(intent.getStringExtra("Groupname"));
        
        SaveGroup();
        for (int i=0;i<list.size();i++)
            listShow.add(false);







        final FriendListAdapter adapterItem = new FriendListAdapter(this, list);
        listview.setAdapter(adapterItem);

        addGroup = (Button) findViewById(R.id.ADDGroup);
        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentre = new Intent();
                intentre = intentre.setClass(GroupActivity.this, FriendsSettingActivity.class);
                startActivity(intentre);
            }
        });
        DecGroup =(Button) findViewById(R.id.DecGroup);
        DecGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = settings.edit();
               for (int i=0;i<listShow.size();i++){
                   if(listShow.get(i)==true) {

                       editor.remove(list.get(i).toString());
                       editor.commit();
                       list.remove(i);
                       listShow.remove(i);
                       i=0;

                   }




               }
                SaveGroup();
                listview.setAdapter(adapterItem);

            }
        });

        EnterGroup = (Button) findViewById(R.id.Entergroups);
        EnterGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> friendsall = new ArrayList<String>();

                int Length = names.length;
                FlistShow=new boolean[Length];
                CGrouplist=new ArrayList<String>();

                for (int i=0;i<listShow.size();i++){

                    if(listShow.get(i)) {
                        CGrouplist.add(list.get(i));



                        String listString =settings.getString(list.get(i),"");
                        String[] itemlists= listString.split(",");
                        for(int j=0;j<itemlists.length;j++){
                            friendsall.add(itemlists[j]);
                            for (int k=0;k<Length;k++)
                                if (itemlists[j].equals(names[k]))
                                    FlistShow[k]=true;

                        }
                    }

                }


                Intent intentre = new Intent();
                intentre = intentre.setClass(GroupActivity.this, MapsActivity.class);
                intentre.putStringArrayListExtra("Grouplist", (ArrayList<String>) CGrouplist);


                intentre.putExtra("FriendsCheck", FlistShow);
                startActivity(intentre);
            }
        });


    }

    private void SaveGroup(){

        StringBuilder stringBuilder =new StringBuilder();
        for (String s:list){
            stringBuilder.append(s);
            stringBuilder.append(",");


        }


        SharedPreferences.Editor editor=settings.edit();
        editor.putString("list",stringBuilder.toString());
        editor.commit();

        if(settings.getString("list","")==""){
            Intent intentre = new Intent();
            intentre = intentre.setClass(GroupActivity.this, FriendsSettingActivity.class);
            startActivity(intentre);

        }


    }
    private void LoadGroup(){



        String listString =settings.getString("list","");
        String[] itemlists= listString.split(",");
        for(int i=0;i<itemlists.length;i++){
            list.add(itemlists[i]);

        }
        list.remove("");



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }





    @Override
    protected void onStart() {
        super.onStart();

        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }
}
