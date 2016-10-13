package com.example.minh.getdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.lv_data)
    ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://jsonplaceholder.typicode.com/posts").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse");
                String bodyString = response.body().string();
                Gson gson = new Gson();
                final Item[] data = gson.fromJson(bodyString,Item[].class);
 //               Log.d(TAG, String.format("data lenght %s", data.length));
 //               Log.d(TAG, data[0].getTitle());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Adapter adapter = new Adapter(getBaseContext(),R.layout.listview_customization, data);
                        lvData.setAdapter(adapter);
                    }
                });

            }
        });
    }
}
