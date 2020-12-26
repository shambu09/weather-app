package com.acro.weatherapp.spider;

import android.net.ConnectivityManager;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.SocketTimeoutException;


public class Crawler extends AsyncTask<Double, Void, Response> {
    private final String TAG = "Crawler";
    private final String url_genAddress = "https://weather.com/en-IN/weather/tenday/l/";
    private final String suffix = "?par=google&temp=c";
    private final URL url = new URL(url_genAddress, suffix);
    private final SpiderCallBack listener;
    private final ConnectivityManager cm;

    public Crawler(SpiderCallBack listener, ConnectivityManager cm){
        this.listener = listener;
        this.cm = cm;
    }

    private boolean getConnectivity(){
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public Response sync_getWeather(Double latitude, Double longitude) {
        Document doc;
        Elements w;
        String url_gen = url.buildUrl(latitude, longitude);
        String selector = "details.Disclosure--themeList--uBa5q[index ='1'] span.DetailsSummary--extendedData--aaFeV";
        Response response = new Response("Error",new SocketTimeoutException());

        if (this.getConnectivity())
        {
            try {
                doc = Jsoup.connect(url_gen).get();
                w = doc.select(selector);
                response.data = w.get(0).text();
                response.exception = null;
            } catch (Exception e) {
                response.data = "Error";
                response.exception = e;
            }
        }
        return response;
    }

    @Override
    protected Response doInBackground(Double... ds) {
        double latitude = ds[0];
        double longitude = ds[1];
        return this.sync_getWeather(latitude, longitude);
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        listener.onCrawlCompleted(response);
    }
}
