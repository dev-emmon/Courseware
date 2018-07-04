package me.imli.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.imli.broadcastreceiver.br.BRActivity;
import me.imli.broadcastreceiver.br.MyBroadcastReceiver;
import me.imli.broadcastreceiver.ordered.ORActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_b_r).setOnClickListener(this);
        findViewById(R.id.btn_o_b_r).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_b_r:
                startActivity(new Intent(MainActivity.this, BRActivity.class));
                break;
            case R.id.btn_o_b_r:
                startActivity(new Intent(MainActivity.this, ORActivity.class));
                break;
        }
    }
}