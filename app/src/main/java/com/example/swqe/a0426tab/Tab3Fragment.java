package com.example.swqe.a0426tab;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import android.view.Window;


//import static com.example.swqe.a0426tab.Parser.aa;

public class Tab3Fragment  extends Fragment  {
    private static final String TAG = "Tab3Fragment";

    private ProgressDialog progressBar;
    private Button btn3;
    //show your progressdialog here
    // private TextView tv3;

    private WebViewFragment web_1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View v = inflater.inflate(R.layout.tab3_fragment,container,false);

        View v=inflater.inflate(R.layout.tab3_fragment, container, false);



        Log.d(TAG, "Parser aa: "+Parser.aa);
        WebView web_1 = v.findViewById(R.id.web_1);
        WebSettings setting = web_1.getSettings();
        setting.setJavaScriptEnabled(true);



        web_1.setWebViewClient(new WebViewClient());

        web_1.getSettings().setUseWideViewPort(true);
        web_1.getSettings().setLoadWithOverviewMode(true);

        //web_1.setWebViewClient(new MyWebViewClient());

        web_1.loadUrl("http://swqereport.ddns.net:8050/daily/inde.php?project_id="+Parser.aa);
        //web_1.loadUrl("http://192.168.1.15:8083/daily/inde.php?project_id="+Parser.aa);


        return v;

    }

//    private class MyWebViewClient extends WebViewClient {
//        ProgressDialog  pd = new ProgressDialog(getActivity());
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            //remove your progressdialog here
//            pd.dismiss();
//            super.onPageFinished(view, url);
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//
//            pd.setTitle("Fetch Data");
//            pd.setMessage("Fetching Data...Please wait");
//            pd.show();
//            super.onPageStarted(view, url, favicon);
//        }
//
//    }
}
