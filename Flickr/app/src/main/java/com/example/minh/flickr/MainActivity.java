package com.example.minh.flickr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.lv_flickr)
    ListView lvFlickr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContent();
        ButterKnife.bind(this);
    }

    private void getContent() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.flickr.com/services/feeds/photos_public.gne?tags=girl&format=json&title=girl").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse");
                String body = response.body().string().replace("jsonFlickrFeed(", "").replace("})", "}");
                final FlickrFeed flickrFeed = new Gson().fromJson(body, FlickrFeed.class);
                final List<FlickrItem> flickrItems = flickrFeed.getItems();
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lvFlickr.setAdapter(new Adapter(getBaseContext(), R.layout.listview_customization, flickrItems));
                    }
                });
            }
        });
    }
}
