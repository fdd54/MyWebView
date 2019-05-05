package com.example.fjnu.fdd.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        webView=(WebView)findViewById(R.id.webview);
        Bundle bundle=getIntent().getExtras();
        String url=bundle.getString("url");
        Log.i("dd",url);
        //String url="https://www.baidu.com";

        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制网页在WebView中去打开，如果为false调用系统浏览器或第三方浏览器去打开
                webView.loadUrl(url);
                return true;
            }
        });
    }
}
