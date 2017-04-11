package com.wenhan.echat.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

import com.wenhan.echat.ui.BaseActivity;
import com.wenhan.echat.ui.login.LoginActivity;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class RlMsgHandleCenterReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //初始化
        if (intent.getAction().equals(Constants.ACTION_NAME_INIT)) {
            handleInitMsg(intent);
        }
        //账号连接
        if (intent.getAction().equals(Constants.ACTION_NAME_CONNECT)) {
            handleConnectMsg(intent);
        }
    }

    //处理初始化SDK消息
    private void handleInitMsg(Intent intent) {
        String status = intent.getStringExtra(Constants.INIT_KEY);
        //初始化成功
        if (status.equals(Constants.INIT_KEY_COMPLETE)) {
            if (BaseActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = BaseActivity.MSG_INIT_STATUS;
                msg.arg1 = BaseActivity.MSG_INIT_STATUS_COMPLETE;
                BaseActivity.uiHandler.sendMessage(msg);
            }
        }
        //初始化失败
        if (status.equals(Constants.INIT_KEY_FAILED)) {
            if (BaseActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = BaseActivity.MSG_INIT_STATUS;
                msg.arg1 = BaseActivity.MSG_INIT_STATUS_FAILED;
                BaseActivity.uiHandler.sendMessage(msg);
            }
        }
    }

    //处理账号连接消息
    private void handleConnectMsg(Intent intent) {
        String status = intent.getStringExtra(Constants.CONNECT_KEY);
        //连接成功
        if (status.equals(Constants.CONNECT_KEY_COMPLETE)) {
            if (BaseActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = BaseActivity.MSG_CONNECT_STATUS;
                msg.arg1 = BaseActivity.MSG_CONNECT_STATUS_COMPLETE;
                BaseActivity.uiHandler.sendMessage(msg);
            }
            if (LoginActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = LoginActivity.MSG_CONNECT_STATUS;
                msg.arg1 = LoginActivity.MSG_CONNECT_STATUS_COMPLETE;
                LoginActivity.uiHandler.sendMessage(msg);
            }
        }
        //连接失败
        if (status.equals(Constants.CONNECT_KEY_FAILED)) {
            if (BaseActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = BaseActivity.MSG_CONNECT_STATUS;
                msg.arg1 = BaseActivity.MSG_CONNECT_STATUS_FAILED;
                BaseActivity.uiHandler.sendMessage(msg);
            }
            if (LoginActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = LoginActivity.MSG_CONNECT_STATUS;
                msg.arg1 = LoginActivity.MSG_CONNECT_STATUS_FAILED;
                LoginActivity.uiHandler.sendMessage(msg);
            }
        }
        //连接失败 - 异地登录
        if (status.equals(Constants.CONNECT_KEY_KICKED_OFF)) {
            if (BaseActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = BaseActivity.MSG_CONNECT_STATUS;
                msg.arg1 = BaseActivity.MSG_CONNECT_STATUS_FAILED_KICKED_OFF;
                BaseActivity.uiHandler.sendMessage(msg);
            }
            if (LoginActivity.uiHandler != null) {
                Message msg = new Message();
                msg.what = LoginActivity.MSG_CONNECT_STATUS;
                msg.arg1 = LoginActivity.MSG_CONNECT_STATUS_FAILED_KICKED_OFF;
                LoginActivity.uiHandler.sendMessage(msg);
            }
        }
    }

}
