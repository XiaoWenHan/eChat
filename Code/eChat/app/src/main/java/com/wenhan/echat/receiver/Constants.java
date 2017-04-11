package com.wenhan.echat.receiver;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class Constants {

    /**
     * 初始化相关
     */
    public static final String ACTION_NAME_INIT = "com.wenhan.echat.init";

    /**
     * 初始化状态
     */
    public static final String INIT_KEY = "status";

    /**
     * 初始化状态 成功
     */
    public static final String INIT_KEY_COMPLETE = "ok";

    /**
     * 初始化状态 失败
     */
    public static final String INIT_KEY_FAILED = "failed";

    /**
     * 账号登录连接
     */
    public static final String ACTION_NAME_CONNECT = "com.wenhan.echat.connect";

    /**
     * 连接状态
     */
    public static final String CONNECT_KEY = "status";

    /**
     * 连接状态 成功
     */
    public static final String CONNECT_KEY_COMPLETE = "ok";

    /**
     * 连接状态 异地登录
     */
    public static final String CONNECT_KEY_KICKED_OFF = "kick_off";

    /**
     * 连接状态 失败
     */
    public static final String CONNECT_KEY_FAILED = "failed";

}
