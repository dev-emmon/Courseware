package me.imli.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            list.add("第" + i +"个Item");
        }

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        ListAdapter adapter = new ListAdapter();
        recyclerView.setAdapter(adapter);

    }


    class ListAdapter extends RecyclerView.Adapter<ListVH>  {


        @Override
        public ListVH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListVH(View.inflate(MainActivity.this, R.layout.item_layout, null));
        }

        @Override
        public void onBindViewHolder(ListVH holder, int position) {
            String str = list.get(position);
            holder.textView.setText(str);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ListVH extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;


        public ListVH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
