package com.example.swqe.a0426tab;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;


public class Tab1Fragment extends Fragment{
    private static final String TAG = "Tab1Fragment";

    private SectionsPageAdapter mSectionsPageAdapter;
    private Button btn1;
    private  Button btntest;

    private TextView tv2;

    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        btn1 = (Button) view.findViewById(R.id.btn1);
        btntest = (Button) view.findViewById(R.id.btntest);
        tv2=(TextView) view.findViewById(R.id.tv2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();


            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("YYYY");
            }
        });



        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "test11111", Toast.LENGTH_SHORT).show();
                //getFragmentManager().beginTransaction().hide(Tab1Fragment.this).commitAllowingStateLoss();
                //getFragmentManager().beginTransaction().add(R.id.main_content, new Tab3Fragment()).commitAllowingStateLoss();



                ((MainActivity)getActivity()).setViewPager(2);

            }
        });



        return  view;

    }





}
