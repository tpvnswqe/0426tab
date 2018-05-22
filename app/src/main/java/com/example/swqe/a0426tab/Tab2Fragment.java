package com.example.swqe.a0426tab;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.view.ViewPager;

import org.json.JSONException;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button btn2;

    private SectionsPageAdapter mSectionsPageAdapter;
    private Button btn1;
    private  Button btntest;

    private TextView tv2;
    Context c;
    private ViewPager mViewPager;

    private boolean isViewShown = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        this.c = c;

        Log.d(TAG, "onCreateView: 1111");
//        btn2 = (Button) view.findViewById(R.id.btn2);
//        tv2 = (TextView)view.findViewById(R.id.tv2);
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv2.setText("Hello World");
//                tv2.setTextSize(50);
//            }
//        });
//
//        btn1 = (Button) view.findViewById(R.id.btn1);
//        btntest = (Button) view.findViewById(R.id.btntest);
//        tv2=(TextView) view.findViewById(R.id.tv2);
//
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        tv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv2.setText("YYYY");
//            }
//        });

//        btntest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "test11111", Toast.LENGTH_SHORT).show();
//                //getFragmentManager().beginTransaction().hide(Tab1Fragment.this).commitAllowingStateLoss();
//                //getFragmentManager().beginTransaction().add(R.id.main_content, new Tab3Fragment()).commitAllowingStateLoss();
//                ((MainActivity)getActivity()).setViewPager(2);
//            }
//        });
        if (!isViewShown) {
            //showList();
        }


        final ListView lv2 = (ListView) view.findViewById(R.id.lv2);
        //ListView 要顯示的內容
        String[] str = {"Project Name:", "Project ID:","Region:","SWQE Leader:","SW Score:","Chipset:"};

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, str);
        lv2.setAdapter(adapter);

        ListView lv3= (ListView) view.findViewById(R.id.lv3);
        //ListView 要顯示的內容
        //String[] str = {"ProJect Name","Region","SWQE Leader","SW Score","Chipset"};
        //lv3.refreshDrawableState();


        try {
            String[] str2 = {Parser.projectdata, Parser.projectregion, Parser.projectleader, Parser.projectscore, Parser.projectchip};
            adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, str2);
            lv3.setAdapter(adapter);
            lv3.refreshDrawableState();
        }catch (Exception e) {
            System.out.println("分母不可為0");
        }


        return  view;
    }


    public void setUserVisibleHint(boolean isVisibleToUser) {
        //ListView lv3 = getView().findViewById(R.id.lv3);
        //v.findViewById(R.id.lv3);

        Log.d(TAG, "setUserVisibleHint: ");

        super.setUserVisibleHint(isVisibleToUser);
        if (getView() != null) {
            isViewShown = true;
            Log.d(TAG, "isViewShown = true: ");
            String[] str2 = {Parser.projectdata, Parser.projectid2, Parser.projectregion, Parser.projectleader, Parser.projectscore, Parser.projectchip};
            ListView lv3 = getView().findViewById(R.id.lv3);

            try {
                ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, str2);
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, str2);
                lv3.setAdapter(adapter);
                //lv3.refreshDrawableState();
            }catch (Exception e) {
                System.out.println("分母不可為0");
            }


            //showList();
        } else {
            isViewShown = false;
            Log.d(TAG, "isViewShown = false: ");
        }
    }


}
