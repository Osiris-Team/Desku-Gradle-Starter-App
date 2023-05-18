package com.author.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.osiris.desku.Route;
import com.osiris.desku.UI;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AndroidUI extends UI {
    private class MyWebViewClient extends WebViewClient {
        public final AtomicBoolean isPageLoaded = new AtomicBoolean(false);
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Return false to let WebView handle the URL loading
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            isPageLoaded.set(true);
        }
    }
    public WebView webView;

    public AndroidUI(Route route) throws IOException {
        super(route);
    }

    public AndroidUI(Route route, boolean isTransparent, int widthPercent, int heightPercent) throws IOException {
        super(route, isTransparent, widthPercent, heightPercent);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void init(String startURL, boolean isTransparent, int widthPercent, int heightPercent) throws Exception {
        // Create a new WebView instance
        Context context = AndroidUIManager.mainActivity.getApplicationContext(); // Replace with your context reference
        webView = new WebView(context);

        // Configure WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if (isTransparent) {
            webView.setBackgroundColor(0x00000000); // Transparent background
        }

        // Attach WebViewClient to handle page loading
        MyWebViewClient myWebViewClient = new MyWebViewClient();
        webView.setWebViewClient(myWebViewClient);

        // Attach WebChromeClient for JavaScript console logging
        webView.setWebChromeClient(new WebChromeClient());

        // Load the provided startURL
        webView.loadUrl(startURL);

        // Set the dimensions of the WebView
        // Note: You may need to adjust the widthPercent and heightPercent calculation based on your requirements
        //int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        //int screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        //int width = (int) (screenWidth * (widthPercent / 100.0));
        //int height = (int) (screenHeight * (heightPercent / 100.0));
        //ebView.setLayoutParams(new LayoutParams(width, height));

        // Add the WebView to your layout or view hierarchy
        // Replace 'yourContainer' with the appropriate container view
        AndroidUIManager.mainActivity.setContentView(webView);

        // JavaScript cannot be executed before the page is loaded
        while (!myWebViewClient.isPageLoaded.get()) Thread.yield();
    }

    @Override
    public void width(int widthPercent) {

    }

    @Override
    public void height(int heightPercent) {

    }

    @Override
    public void plusX(int x) {

    }

    @Override
    public void plusY(int y) {

    }

    @Override
    public void executeJavaScript(String jsCode, String jsCodeSourceName, int jsCodeStartingLineNumber) {
        webView.loadUrl("javascript:(function() { " + jsCode + " })()");
    }
}
