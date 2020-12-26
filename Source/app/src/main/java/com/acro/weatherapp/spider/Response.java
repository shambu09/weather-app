package com.acro.weatherapp.spider;

public class Response{
        public String data;
        public Exception exception;

        public Response(String data, Exception e) {
            this.data = data;
            this.exception = e;
        }
}
