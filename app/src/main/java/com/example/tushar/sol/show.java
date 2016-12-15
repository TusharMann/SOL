package com.example.tushar.sol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class show extends AppCompatActivity {

    String download_file_url = "https://drive.google.com/open?id=0B3Q3M7qljFv2aC0wQ29RWWRMSXc";
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("path",download_file_url);



        wv=(WebView)findViewById(R.id.webview);
        wv.getSettings().setJavaScriptEnabled(true);

        wv.getSettings().setPluginState(WebSettings.PluginState.ON);

        wv.getSettings().setAllowFileAccess(true);
        wv.loadUrl(download_file_url);
//        webView.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading (WebView view, String url) {
//                if (url.endsWith(".pdf")) {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//                    // if want to download pdf manually create AsyncTask here
//                    // and download file
//                    return true;
//                }
//                return false;
//            }
//        });
//

    }

}
