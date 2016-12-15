package com.example.tushar.sol;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class show extends AppCompatActivity {

    String download_file_url = "http://sol.du.ac.in/admission/FeeReceipt_Dashboard.aspx?&SOL_ROLL_NO=04-1-02-000776&RECEIPT_NO=07-01-065231";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("path",download_file_url);



        webView=(WebView)findViewById(R.id.webview);
//        Uri uri= Uri.parse(download_file_url);
       //  webView.loadUrl(download_file_url);
//        setContentView(view);

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading (WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    // if want to download pdf manually create AsyncTask here
                    // and download file
                    return true;
                }
                return false;
            }
        });


    }

}
