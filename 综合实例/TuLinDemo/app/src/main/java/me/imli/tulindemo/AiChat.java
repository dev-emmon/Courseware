package me.imli.tulindemo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * 图灵 Ai 聊天接口类
 *
 * Created by Em on 2017/11/23.
 */

public class AiChat {

    private OkHttpClient client;

    public AiChat() {
        client = new OkHttpClient();
    }

    /**
     * 聊天接口
     * @param msg
     * @return
     */
    public String chat(String msg) {

        // 接口地址
        String api = "http://www.tuling123.com/openapi/api";
        // app_key
        String key_value = "7af7df3e167ffcafe5c7d57a70c5c3b5";
        // 由 接口地址，app_key, info 组成 url 接口
        String url = api + "?" + "key=" + key_value + "&info=" + msg;
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            // 获取接口返回消息
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 如果网络出错没有获取到回复消息，返回 null
        return null;
    }

}
