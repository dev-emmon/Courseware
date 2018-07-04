package me.imli.tulindemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 *
 * 消息数据模型
 *
 * Created by Em on 2017/11/23.
 */

@Entity
public class MessageData {

    @Id(autoincrement = true)
    private Long id;

    /**
     * 是否是自己发送的消息
     */
    public boolean me;

    /**
     * 存储发送的消息
     */
    public String msg;

    @Generated(hash = 1582408471)
    public MessageData(Long id, boolean me, String msg) {
        this.id = id;
        this.me = me;
        this.msg = msg;
    }

    @Generated(hash = 723026249)
    public MessageData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getMe() {
        return this.me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
