package com.love.pop;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainPresenter extends BasePresenter<MainView>{

    private String needData;

    @Override
    public void onCreateView(Bundle saveInstance) {
        mView.showProgress();
        needData = mView.getContext().getString(R.string.opening_url);
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }


    public void loadData(WebView webView) {
        mView.hideProgress();
        webView.setWebViewClient(createClient());
        initSetting(webView.getSettings());
        webView.loadUrl(needData);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initSetting(WebSettings webSettings) {
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
    }

    private WebViewClient createClient() {
        return new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                mView.onOverloading(url);
                return true;
            }

            @RequiresApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                mView.onOverloading(request.getUrl().toString());
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                mView.hideProgress();
                mView.onErrorNetwork(error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                mView.hideProgress();
                mView.onErrorNetworkHttp(errorResponse);
            }
        };
    }
}
