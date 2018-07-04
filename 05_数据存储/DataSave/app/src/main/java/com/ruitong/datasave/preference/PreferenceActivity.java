package com.ruitong.datasave.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.ruitong.datasave.R;

/**
 * Created by Em on 2016/7/13.
 */
public class PreferenceActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SP_NAME = "sp";

    EditText etReadKey;
    EditText etSaveKey;
    EditText etSaveValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        etReadKey = (EditText) findViewById(R.id.et_read_key);
        etSaveKey = (EditText) findViewById(R.id.et_save_key);
        etSaveValue = (EditText) findViewById(R.id.et_save_value);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_read).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_read:
                String key = etReadKey.getText().toString().trim();
                SharedPreferences sps = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
                String value = sps.getString(key, "");
                etSaveKey.setText(key);
                etSaveValue.setText(value);
                Log.d(getClass().getSimpleName(), "key " + key + "  ===>  " + "value: " + value);
                break;
            case R.id.btn_save:
                SharedPreferences sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor et = sp.edit();
                et.putString(etSaveKey.getText().toString().trim(), etSaveValue.getText().toString().trim());
                etSaveKey.setText("");
                etSaveValue.setText("");
                et.commit();
                Log.d(getClass().getSimpleName(), "SharedPreferences save success!");
                break;
        }
    }
}
