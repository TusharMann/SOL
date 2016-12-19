package com.example.tushar.sol;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class show extends AppCompatActivity {

    String download_file_url = "http://sol.du.ac.in/admission/FeeReceipt_Dashboard.aspx?&SOL_ROLL_NO=04-1-02-000776&RECEIPT_NO=07-01-065231";
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

        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        wv.getSettings().setAllowFileAccess(true);
//        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//
//        wv.addJavascriptInterface(new MyJavaScriptInterface(getApplicationContext()),"HTMLOUT");
//
//        wv.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                Log.i("Html","Inside");
//                wv.loadUrl("javascript:window.HtmlViewer.showHTML" +
//                        "('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
//            }
//        });

       wv.loadUrl(download_file_url);

       // wv.loadUrl("javascript:window.HTMLOUT.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
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

    class MyJavaScriptInterface
    {
        private Context ctx;

        MyJavaScriptInterface(Context ctx) {
            this.ctx = ctx;
        }

        @SuppressWarnings("unused")
        public void showHTML(String html)
        {
            Log.i("Html",html);

        }
    }


}
