package me.imli.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave;
    Button btnRead;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_input);
        btnSave = findViewById(R.id.btn_save);
        btnRead = findViewById(R.id.btn_read);
        btnRemove = findViewById(R.id.btn_remove);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String info = editText.getText().toString();
                save(info);

                // 弹出一个消息提示
                Toast.makeText(MainActivity.this, "消息保存成功", Toast.LENGTH_SHORT).show();

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = get();

                // 弹出读取到的信息
                Toast.makeText(MainActivity.this, "读取到的信息是 ===>  " + info, Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove();

                // 弹出删除成功提示
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void save(String info) {
        SharedPreferences sharedPreferences = getSharedPreferences("demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", info);
        editor.commit();
    }

    private String get() {
        SharedPreferences sharedPreferences = getSharedPreferences("demo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Name", "");
    }

    private void remove() {
        SharedPreferences sharedPreferences = getSharedPreferences("demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("Name");
        editor.commit();
    }


}
