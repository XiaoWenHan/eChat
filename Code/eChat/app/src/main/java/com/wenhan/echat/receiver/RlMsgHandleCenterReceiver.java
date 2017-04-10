package com.wenhan.echat.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

import com.wenhan.echat.ui.BaseActivity;

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
                Message msg = new Message();
                msg.what = BaseActivity.MSG_INIT_STATUS;
                msg.arg1 = BaseActivity.MSG_INIT_STATUS_FAILED;
                BaseActivity.uiHandler.sendMessage(msg);
            }
        }
        //账号连接
        if (intent.getAction().equals(Constants.NAME_CONNECT)) {

        }
    }


}
