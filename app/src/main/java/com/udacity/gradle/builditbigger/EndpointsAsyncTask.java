package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.sunny.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi myApiService = null;
    private OnTaskCompleted mListener;

    public EndpointsAsyncTask(OnTaskCompleted listener) {
        this.mListener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - set to test on a physical device with a local development server
                    // (to get your ip address, go to cmd -> ipconfig -> IPV4 address with port number)
                    .setRootUrl("http://192.168.1.114:8080/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mListener.onTaskCompleted(result);
    }
}