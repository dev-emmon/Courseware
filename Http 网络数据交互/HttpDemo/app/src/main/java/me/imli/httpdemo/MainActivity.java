package me.imli.httpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (msg.what == 1) {
                    // 线程 1 发过来的消息
                    String str = (String) msg.obj;

                    // 使用 Gson 解析 json 数据
                    Data data = new Gson().fromJson(str, Data.class);

                    // 使用 Gson 把 obj 转成 json 字符串
//                    String jsonStr = new Gson().toJson(data);

                    // 弹出提示信息
                    Toast.makeText(MainActivity.this, data.message, Toast.LENGTH_SHORT).show();
                }
            }
        };

    }


    /**
     * Get 方法获取信息
     * @param view
     */
    public void getData(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://192.168.1.106:5000/")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String str = response.body().string();

                    // 弹出提示框显示获取到的信息
                    Log.d("MainActivity", str);

                    Message message = new Message();
                    message.what = 1;
                    message.obj = str;

                    handler.sendMessage(message);
//                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void postData(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client = new OkHttpClient();

                    RequestBody formBody = new FormBody.Builder()
                            .add("abc", "Jurassic Park")
                            .build();

                    Request request = new Request.Builder()
                            .url("http://192.168.1.106:5000/test")
                            .post(formBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String str = response.body().string();

                    Log.d("MainActivity", str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
