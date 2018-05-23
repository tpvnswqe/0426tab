package com.example.swqe.a0426tab;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.app.Application;

import static android.content.Context.MODE_PRIVATE;
import android.support.v4.view.ViewPager;


/**
 * Created by Prasanga Fernando on 12/3/2017.
 */


public class Parser extends AsyncTask<Void,Integer,Integer> {
    Context c;
    ListView lv;
    String data;
    public static String aa ="";
    public static String projectdata = "";
    public static String projectid2 = "";
    public static String projectregion = "";
    public static String projectleader = "";
    public static String projectscore = "";
    public static String projectchip = "";
    public static int select_item=-1; //一開始未選擇任何一個item所以為-1

    private MainActivity mainActivity;
    public static final int CHOICE_MODE_SINGLE = 1;

    private static final String TAG = "TT" ;

    ArrayList<String> players=new ArrayList<>();
    ProgressDialog pd;

    public Parser(Context c, String data, ListView lv) {
        this.c = c;
        this.data = data;
        this.lv = lv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing ....Please wait");
        //pd.show();
    }
    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();

    }


    @Override
    protected void onPostExecute (Integer integer) {
        super.onPostExecute(integer);
        if(integer == 1)
        {
            //ADAPTER
            final ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_single_choice,players);
            //ADAPT TO LISTVIEW

            lv.setChoiceMode(CHOICE_MODE_SINGLE );
            lv.setAdapter(adapter);
            lv.setItemChecked(select_item,true);



            //LISTENET
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                View view2; //保存點選的View
                //int select_item=-1; //一開始未選擇任何一個item所以為-1

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Snackbar.make(view,players.get(position),Snackbar.LENGTH_LONG).show();



                    Log.d(TAG, "onItemClick: "+lv.getCheckedItemPosition());

                    //======================
                    //點選某個item並呈現被選取的狀態
                    if ((select_item == -1) || (select_item==position)){
                        //Log.d(TAG, "onItemClick: "+select_item);
                        Log.d(TAG, "position:  "+ position);
//                        view.setBackgroundColor(Color.YELLOW); //為View加上選取效果
                    }else{
//                        view2.setBackgroundDrawable(null); //將上一次點選的View保存在view2
//                        view.setBackgroundColor(Color.YELLOW); //為View加上選取效果
                    }
                    view2=view; //保存點選的View
                    select_item=position;//保存目前的View位置
                    //======================

                    try {
                        MainActivity.mViewPager.setOffscreenPageLimit(1);
                        //ADD THAT DATA TO JSON ARRAY FIRST
                        JSONArray ja = new JSONArray(data);
                        //CREATE JO OBJ TO HOLD A SINGLE ITEM
                        JSONObject jo = null;
                        jo=ja.getJSONObject(position);
                        String name=jo.getString("project_id");

                        aa = name;
                        projectdata= jo.getString("project_name");
                        projectid2 = jo.getString("project_id2");
                        projectregion= jo.getString("region");
                        projectleader= jo.getString("project_leader");
                        projectscore= jo.getString("sw_score");
                        projectchip= jo.getString("chipset");

                        MainActivity.mViewPager.setOffscreenPageLimit(2);


                        //(MainActivity.this).setViewPager(2);
                        //((MainActivity) getActivity()).setViewPager(2);

                        //Snackbar.make(view,name, Snackbar.LENGTH_LONG).show();



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }else
        {
            Toast.makeText(c,"Unable to Parse", Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }
    //PARSE RECEIVED DATA


    private int parse()
    {
        try
        {
            //ADD THAT DATA TO JSON ARRAY FIRST
            JSONArray ja=new JSONArray(data);
            //CREATE JO OBJ TO HOLD A SINGLE ITEM
            JSONObject jo=null;
            players.clear();
            //LOOP THRU ARRAY
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                //RETRIOEVE NAME
                String name=jo.getString("project_name");//This is the column name you want toi retrieve
//                String id=jo.getString("project_id");
//                name = id+ " " + name;
                //ADD IT TO OUR ARRAYLIST
                players.add(name);
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }



}

