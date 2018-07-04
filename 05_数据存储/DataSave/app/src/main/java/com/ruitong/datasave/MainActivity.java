package com.ruitong.datasave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ruitong.datasave.db.DBActivity;
import com.ruitong.datasave.file.FileActivity;
import com.ruitong.datasave.json.JsonActivity;
import com.ruitong.datasave.preference.PreferenceActivity;
import com.ruitong.datasave.xml.XmlActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_sp).setOnClickListener(this);
        findViewById(R.id.btn_file).setOnClickListener(this);
        findViewById(R.id.btn_db).setOnClickListener(this);
        findViewById(R.id.btn_json).setOnClickListener(this);
        findViewById(R.id.btn_xml).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sp:
                Intent intent1 = new Intent(MainActivity.this, PreferenceActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_file:
                Intent intent2 = new Intent(MainActivity.this, FileActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_db:
                Intent intent3 = new Intent(MainActivity.this, DBActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_json:
                Intent intent4 = new Intent(MainActivity.this, JsonActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_xml:
                Intent intent5 = new Intent(MainActivity.this, XmlActivity.class);
                startActivity(intent5);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
