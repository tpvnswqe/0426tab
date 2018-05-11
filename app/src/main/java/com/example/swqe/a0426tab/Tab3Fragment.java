package com.example.swqe.a0426tab;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class Tab3Fragment  extends Fragment  {
    private static final String TAG = "Tab3Fragment";

    private Button btn3;
    // private TextView tv3;

    private WebViewFragment web_1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View v = inflater.inflate(R.layout.tab3_fragment,container,false);

        View v=inflater.inflate(R.layout.tab3_fragment, container, false);

        WebView web_1 = v.findViewById(R.id.web_1);
        WebSettings setting = web_1.getSettings();
        setting.setJavaScriptEnabled(true);


        web_1.setWebViewClient(new WebViewClient());
        web_1.loadUrl("http://10.0.1.117:8083/daily/inde.php");

        return v;

    }
}
