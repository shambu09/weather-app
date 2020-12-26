package com.acro.weatherapp.spider;

import java.text.DecimalFormat;

public class URL {
    public final String prefix;
    public final String suffix;
    public String url;

    DecimalFormat formatHandler = new DecimalFormat("##.##");

    public URL(String i_prefix, String i_suffix){
        prefix = i_prefix;
        suffix = i_suffix;
    }

    public String buildUrl(Double latitude, Double longitude){
        String cords = (String) formatHandler.format(latitude) + "," + (String) formatHandler.format(longitude);
        url = prefix + cords + suffix;
        return url;
    }

    public String get(){
        return url;
    }
}
