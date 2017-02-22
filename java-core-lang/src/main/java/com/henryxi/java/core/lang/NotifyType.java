package com.henryxi.java.core.lang;

/**
 * Created by ray on 2017/1/18.
 */
public enum NotifyType {

    REMIND("1"),//提醒
    MESSAGE("2"),//私信
    ANNOUNCE("3"),//通知(系统通知)
    COMMENT("4"),//评论和回复
    LIKE("5");//喜欢

    private NotifyType(String value){
        this.value = value;
    }


    private String value;

    public String getValue() {
        return value;
    }
}
