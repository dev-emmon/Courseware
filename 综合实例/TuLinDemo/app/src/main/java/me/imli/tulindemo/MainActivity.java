package me.imli.tulindemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MessageAdapter messageAdapter;

    Button btnSend;
    EditText etMessage;

//    Button btnSendLeftTest;

    // Handler
    Handler handler;
    // 定义一个聊天接口 AiChat 对象
    AiChat aiChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 查找视图控件
        recyclerView = findViewById(R.id.recycler_view);
        btnSend = findViewById(R.id.btn_send);
        etMessage = findViewById(R.id.et_message);


//        btnSendLeftTest = findViewById(R.id.btn_send_left_text);

        // 初始化一个聊天接口 AiChat 对象
        aiChat = new AiChat();

        // 初始化 recyclerView
        messageAdapter = new MessageAdapter(this);
        recyclerView.setAdapter(messageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Activity 启动，加载聊天记录
        firstLoad();

        // 点击发送按钮事件
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();
                sendMessage(true, msg);
                Log.d("MainActivity", "发送消息：" + msg);
                // 点击发送消息后，立马调用聊天接口获取返回的消息
                getChatMessage(msg);
            }
        });

//        // 点击左侧发送按钮事件
//        btnSendLeftTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String msg = etMessage.getText().toString();
//                sendMessage(false, msg);
//            }
//        });

        // 初始化一个 Handler 来接收由其它线程穿过来的消息
        handler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                // 收到消息后进一步对消息进行处理
                if (msg.what == 1) {
                    // 是收到的接口回信
                    AiData data = (AiData) msg.obj;
                    if (data.code == 100000) {
                        // 状态码 100000 ，接口返回正常回复信息
                        MainActivity.this.sendMessage(false, data.text);
                    } else {
                        // 状态码不是 100000 ，错误, 弹出网络错误提示框
                        Toast.makeText(MainActivity.this, "网络错误！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
    }

    /**
     * 获取 MyApp
     * @return
     */
    private MyApp getMyApp() {
        return (MyApp) getApplication();
    }

    /**
     * 获取网络聊天数据
     */
    private void getChatMessage(final String msg) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String str = aiChat.chat(msg);
                Log.d("MainActivity", "收到返回消息：" + str);
                // 通过 Gson 解析收到的消息
                AiData data = new Gson().fromJson(str, AiData.class);
                // 通过 Handler 将消息分发到主线程
                // 定义一个 Message
                Message message = new Message();
                message.what = 1;
                message.obj = data;
                // 发送消息
                handler.sendMessage(message);
            }
        }).start();
    }

    /**
     * 发送消息
     * @param isMe 是否是我发送的消息
     * @param msg 需要发送的消息
     */
    private void sendMessage(Boolean isMe, String msg) {
        // new 一个 MessageData 对象
        MessageData messageData = new MessageData();
        messageData.me = isMe;
        messageData.msg = msg;
        // 把消息插入到数据中保存起来
        getMyApp().getDaoSession().getMessageDataDao().insert(messageData);
        // 插入消息到列表
        messageAdapter.insertMessage(messageData);
        // 列表滑动到底部
        scrollLast();
    }

    /**
     * 程序首次加载
     */
    private void firstLoad() {
        // 查询表里保存的聊天记录
        List<MessageData> datas = getMyApp().getDaoSession().getMessageDataDao().loadAll();
        // 刷新列表
        messageAdapter.updateMessage(datas);
        // 列表滑动到底部
        scrollLast();
    }

    /**
     * 列表滑动到底部
     */
    private void scrollLast() {
        int count = messageAdapter.getItemCount();
        recyclerView.scrollToPosition(count - 1);
    }

}
