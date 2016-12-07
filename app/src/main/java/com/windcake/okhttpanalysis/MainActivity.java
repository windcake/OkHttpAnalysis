package com.windcake.okhttpanalysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.windcake.okhttpanalysis.okhttp3.Call;
import com.windcake.okhttpanalysis.okhttp3.Callback;
import com.windcake.okhttpanalysis.okhttp3.OkHttpClient;
import com.windcake.okhttpanalysis.okhttp3.Request;
import com.windcake.okhttpanalysis.okhttp3.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                                    .url("https://www.baidu.com")
                                     .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                Log.i("aaa",response.body().string());
            }
        });

    }
}
