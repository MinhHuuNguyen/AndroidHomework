package com.example.minh.dailyquote.Fragment;


import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minh.dailyquote.Constants.Constants;
import com.example.minh.dailyquote.JsonModel.QuotesJsonModel;
import com.example.minh.dailyquote.Managers.DbContext;
import com.example.minh.dailyquote.Managers.FileManager;
import com.example.minh.dailyquote.Managers.NetworkManager;
import com.example.minh.dailyquote.Managers.Preferences;
import com.example.minh.dailyquote.Models.Quote;
import com.example.minh.dailyquote.R;
import com.example.minh.dailyquote.Services.QuoteService;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();
    @BindView(R.id.iv_background)
    ImageView ivBackgound;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView((R.id.tv_username))
    TextView tvUsername;

    private File file;

    public ImageLoader imageLoader = ImageLoader.getInstance();

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this,view);
        imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));
        setupUI();
        return view;
    }

    private void updateQuote(final QuotesJsonModel quoteJsonModel){
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(quoteJsonModel.getTitle());
                tvContent.setText(Html.fromHtml(quoteJsonModel.getContent()));
            }
        });
    }

    private void setupUI() {
        tvUsername.setText("Hello " + Preferences.getInstance().getUsername() + " <3 ahihi");
        final String unplash = "unplash";
        if(NetworkManager.getInstance().isConnectedToInternet()){
            imageLoader.loadImage(Constants.UNPLASH_API, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    FileManager.getInstance().createImage(loadedImage, unplash);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });
            file = FileManager.getInstance().loadImageFile(unplash);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(Constants.QUOTES_API).build();
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
                    QuotesJsonModel[] quote = gson.fromJson(bodyString, QuotesJsonModel[].class);
                    if (quote.length > 0){
                        QuoteFragment.this.updateQuote(quote[0]);
                    }
                }
            });

        }else{
            Random random = new Random();
            file = FileManager.getInstance().loadImageFile(String.format("%s.png", random.nextInt(10)));
            Quote quote = DbContext.getInstance().getRandomQuote();
            tvTitle.setText(quote.getTitle());
            tvContent.setText(quote.getContent());
        }
        ImageLoader.getInstance().displayImage(Uri.fromFile(file).toString(), ivBackgound);
    }
}
