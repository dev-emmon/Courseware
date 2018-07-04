package me.imli.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_service_1).setOnClickListener(this);
        findViewById(R.id.btn_service_2).setOnClickListener(this);
        findViewById(R.id.btn_service_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_service_1:
                startActivity(new Intent(MainActivity.this, ServerActivity1.class));
                break;
            case R.id.btn_service_2:
                startActivity(new Intent(MainActivity.this, ServerActivity2.class));
                break;
            case R.id.btn_service_3:
                startActivity(new Intent(MainActivity.this, RemoteServiceActivity.class));
                break;
        }
    }
}
