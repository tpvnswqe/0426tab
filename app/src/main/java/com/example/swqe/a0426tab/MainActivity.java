package com.example.swqe.a0426tab;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Application;




public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    public static ViewPager mViewPager;
    private Button btntest;

    private Parser anotherClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("User" , MODE_PRIVATE);
        sharedPreferences.edit().putString("Name", "Devin").apply();
        sharedPreferences.edit().putInt("Age", 19).apply();

        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //mViewPager.setOffscreenPageLimit(0);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setViewPager(1);

        //實例化一個Bundle物件
        Bundle bb = new Bundle();
        //儲存資料　第一個為參數key，第二個為Value
        bb.putString("key","Value");
        bb.putString("name","learnexp");



    }






    public void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new Tab1Fragment(), "Project List");
        adapter.addFragment(new Tab2Fragment(), "Project Detail");
        adapter.addFragment(new Tab3Fragment(), "Chart");

        //adapter.addFragment(new Tab3Fragment(), "Chart");
        //adapter.addFragment(new Tab3Fragment(), "Chart");
        Log.d(TAG, "setupViewPager");
        //viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);





    }



    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);

    }
    public void setViewPager2(){
        mViewPager.setCurrentItem(2);

    }


}


