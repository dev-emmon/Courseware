package com.ruitong.datasave.file;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ruitong.datasave.R;

/**
 * Created by Em on 2016/7/13.
 */
public class FileActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SAVE_FILE_NAME = "sf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        findViewById(R.id.f_read).setOnClickListener(this);
        findViewById(R.id.f_save).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.f_read:
                Data d2 = (Data) FileUtil.readObjsFromFile(FileActivity.this, SAVE_FILE_NAME);
                Log.d(getClass().getSimpleName(), "get data: " + d2.toString());
                break;
            case R.id.f_save:
                Data d1 = new Data("Test save data", "5648", "Test File save");
                FileUtil.writeObjsToFile(FileActivity.this, d1, SAVE_FILE_NAME, Context.MODE_PRIVATE);
                Log.d(getClass().getSimpleName(), "save success!");
                break;
        }
    }
}
