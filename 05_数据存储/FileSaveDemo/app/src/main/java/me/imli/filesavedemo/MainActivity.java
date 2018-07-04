package me.imli.filesavedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_input);
        btnSave = findViewById(R.id.btn_save);
        btnRead = findViewById(R.id.btn_read);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = editText.getText().toString();

                // 保存
                save(getApplicationContext(), info);

                // 弹出提示框
                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = read(MainActivity.this);

                // 弹出提示框
                Toast.makeText(MainActivity.this, "读取信息 ===> " + info, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 保存
     * @param context Context
     * @param info 保存的信息
     */
    private void save(Context context, String info) {
        if (context == null || info == null)
            return;

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = context.openFileOutput(URLEncoder.encode("demo", "UTF-8"), Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(info);
            oos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取
     * @param context
     * @return
     */
    private String read(Context context) {
        String fileName = "demo";
        if (fileName == null)
            return null;

        Object obj = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            if (context.getFileStreamPath(fileName).exists()) {
                fis = context.openFileInput(fileName);
                ois = new ObjectInputStream(fis);
                obj = ois.readObject();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return obj.toString();
    }

}
