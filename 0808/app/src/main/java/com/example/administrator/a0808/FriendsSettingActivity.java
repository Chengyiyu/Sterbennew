package com.example.administrator.a0808;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FriendsSettingActivity extends AppCompatActivity {
    private Button loginbuttom;
    private static final String TAG = "MainActivity";
    List<String> list;
    ListView listview;
    List<Boolean> listShow;
    boolean[] FriendsCheck;
    String GroupName;

    SharedPreferences settings ;



    private static String[] names = {"成一","仁宏","志偉","育成" , "御浜","祥語","宇可可","松哥","AndyNing","左林"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_setting);



        listview = (ListView) findViewById(R.id.FriendsListSetting);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                                CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1);
                                                chkItem.setChecked(!chkItem.isChecked());
                                                Toast.makeText(FriendsSettingActivity.this, "您點選了 " + names[(position)], Toast.LENGTH_SHORT).show();
                                                listShow.set(position, chkItem.isChecked());
                                            }



                                        }
        );

        settings =getSharedPreferences("PREFS",0);
        listShow = new ArrayList<Boolean>();
        list = new ArrayList<String>();
        GroupName=null;
        for(int x=0;x<names.length;x++)
        {
            list.add(names[x]);
            listShow.add(false);
        }

        FriendListAdapter adapterItem = new FriendListAdapter(this, list);
        listview.setAdapter(adapterItem);






    loginbuttom = (Button) findViewById(R.id.EnterFriends);


        loginbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final int Length = listShow.size();
                FriendsCheck=new boolean[listShow.size()];
                for (int i=0;i<Length;i++){
                    FriendsCheck[i] = listShow.get(i);

                }


                LayoutInflater inflater = LayoutInflater.from(FriendsSettingActivity.this);
                final View vl = inflater.inflate(R.layout.dialog_setting, null);
                new AlertDialog.Builder(FriendsSettingActivity.this)
                        .setTitle("請輸入你的群組名")
                        .setView(vl)
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editText = (EditText) (vl.findViewById(R.id.edit_input));

                                Intent intent = new Intent();
                                intent = intent.setClass(FriendsSettingActivity.this, GroupActivity.class);

                                intent.putExtra("FriendsCheck", FriendsCheck);
                                intent.putExtra("Groupname",editText.getText().toString());
                                StringBuilder stringBuilder =new StringBuilder();
                                for (int i=0;i<Length;i++){
                                    if(FriendsCheck[i]==true){
                                    stringBuilder.append(list.get(i));
                                    stringBuilder.append(",");}
                                }
                                SharedPreferences.Editor editor=settings.edit();
                                editor.putString(editText.getText().toString(),stringBuilder.toString());
                                editor.commit();


                                startActivity(intent);
                            }

                        })
                        .setNeutralButton("取消",new DialogInterface.OnClickListener(){


                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })

                        .show();

            }
        });

    }



}
