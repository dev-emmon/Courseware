package me.imli.tulindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 列表适配器
 *
 * Created by Em on 2017/11/23.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageVH> {

    private List<MessageData> lists;
    private Context mContext;


    public MessageAdapter(Context context) {
        lists = new ArrayList<>();
        mContext = context;
    }

    @Override
    public MessageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageVH(View.inflate(mContext, R.layout.item_message, null));
    }

    @Override
    public void onBindViewHolder(MessageVH holder, int position) {
        // 绑定视图模型 和 数据模型
        MessageData item = lists.get(position);

        if (item.me) {
            // 当消息为自己发送的时候，设置右侧视图可见，左侧视图不可见
            holder.layoutRight.setVisibility(View.VISIBLE);
            holder.layoutLeft.setVisibility(View.GONE);
            // 设置消息与头像
            holder.textViewRight.setText(item.msg);
            holder.imageViewRight.setImageResource(R.mipmap.image_right);
        } else {
            // 当消息不是自己发送的时候，设置左侧视图可见，右侧视图不可见
            holder.layoutRight.setVisibility(View.GONE);
            holder.layoutLeft.setVisibility(View.VISIBLE);
            // 设置消息与头像
            holder.textViewLeft.setText(item.msg);
            holder.imageViewLeft.setImageResource(R.mipmap.image_left);
        }


    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    /**
     * 插入一条新消息
     * @param messageData
     */
    public void insertMessage(MessageData messageData) {
        lists.add(messageData);
        notifyDataSetChanged();
    }

    /**
     * 刷新列表
     * @param datas
     */
    public void updateMessage(List<MessageData> datas) {
        this.lists.clear();
        this.lists.addAll(datas);
        notifyDataSetChanged();
    }

    /**
     * 视图模型
     */
    class MessageVH extends RecyclerView.ViewHolder {

        // 右侧视图控件
        RelativeLayout layoutRight;
        TextView textViewRight;
        ImageView imageViewRight;

        // 左侧视图控件
        RelativeLayout layoutLeft;
        TextView textViewLeft;
        ImageView imageViewLeft;

        public MessageVH(View itemView) {
            super(itemView);

            // 右侧
            layoutRight = itemView.findViewById(R.id.layout_right);
            textViewRight = itemView.findViewById(R.id.text_right);
            imageViewRight = itemView.findViewById(R.id.image_right);

            // 左侧
            layoutLeft = itemView.findViewById(R.id.layout_left);
            textViewLeft = itemView.findViewById(R.id.text_left);
            imageViewLeft = itemView.findViewById(R.id.image_left);
        }
    }

}
