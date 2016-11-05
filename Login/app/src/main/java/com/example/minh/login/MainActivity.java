package com.example.minh.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    Button btnLogIn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserName = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogIn = (Button) findViewById(R.id.btn_login);
        logIn();
    }

    public void logIn(){
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                sendPostRequest(username,password);
            }
        });
    }

    private void sendPostRequest(String username,String password){
        Retrofit loginRetrofit = new Retrofit.Builder().baseUrl("https://a5-tumblelog.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
        Account account = new Account(username,password);
        String jsonBody = new Gson().toJson(account);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),jsonBody);
        LoginService loginService = loginRetrofit.create(LoginService.class);
        loginService.login(body).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                boolean resultString = result.isSuccessful();
                if (resultString){
                    Toast toast = Toast.makeText(MainActivity.this,"LOGGED IN",Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    Toast toast = Toast.makeText(MainActivity.this,"WRONG PASSWORD",Toast.LENGTH_LONG);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}
