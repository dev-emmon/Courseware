package me.imli.fragmentdemo;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_1, new Fragment1()).commit();


        fragmentManager.beginTransaction().replace(R.id.fl_2, new Fragment2()).commit();


        CheckBox box = findViewById(R.id.cb);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.fl_1).setVisibility(View.VISIBLE);
                    findViewById(R.id.fl_2).setVisibility(View.GONE);
                } else {

                    findViewById(R.id.fl_2).setVisibility(View.VISIBLE);
                    findViewById(R.id.fl_1).setVisibility(View.GONE);
                }
            }
        });

    }
}
