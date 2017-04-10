package com.wenhan.echat.util.rl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.wenhan.echat.receiver.Constants;
import com.yuntongxun.ecsdk.ECDevice;
import com.yuntongxun.ecsdk.ECError;
import com.yuntongxun.ecsdk.ECMessage;
import com.yuntongxun.ecsdk.OnChatReceiveListener;
import com.yuntongxun.ecsdk.SdkErrorCode;
import com.yuntongxun.ecsdk.im.ECMessageNotify;
import com.yuntongxun.ecsdk.im.group.ECGroupNoticeMessage;

import java.util.List;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class RLConnectionHelper implements RLConnectionUtil.RLConnectionCallBack, ECDevice.OnECDeviceConnectListener, OnChatReceiveListener {

    private final String TAG = "RLConnectionHelper";

    private Context context;

    private static RLConnectionHelper instance;

    public static RLConnectionHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RLConnectionHelper(context);
        }
        return instance;
    }

    private RLConnectionHelper(Context context) {
        this.context = context;
    }

    @Override
    public void onInitComplete() {
        Log.i(TAG, " 容联SDK服务初始化正常");
        Intent intent = new Intent(Constants.ACTION_NAME_INIT);
        intent.putExtra(Constants.INIT_KEY, Constants.INIT_KEY_COMPLETE);
        context.sendBroadcast(intent);
    }

    @Override
    public void onInitFailed() {
        Log.i(TAG, " 容联SDK服务初始化失败");
        Intent intent = new Intent(Constants.ACTION_NAME_INIT);
        intent.putExtra(Constants.INIT_KEY, Constants.INIT_KEY_FAILED);
        context.sendBroadcast(intent);
    }

    /**
     * @deprecated
     */
    @Override
    public void onConnect() {

    }

    /**
     * @param ecError
     * @deprecated
     */
    @Override
    public void onDisconnect(ECError ecError) {

    }

    @Override
    public void onConnectState(ECDevice.ECConnectState ecConnectState, ECError ecError) {
        if (ecConnectState == ECDevice.ECConnectState.CONNECT_FAILED) {
            if (ecError.errorCode == SdkErrorCode.SDK_KICKED_OFF) {
                Log.i(TAG, "异地登录");
            } else {
                Log.i(TAG, "登录失败" + ecError.errorCode);
            }
            return;
        } else if (ecConnectState == ECDevice.ECConnectState.CONNECT_SUCCESS) {
            Log.i(TAG, "登陆成功");
        }
    }

    @Override
    public void OnReceivedMessage(ECMessage ecMessage) {

    }

    @Override
    public void onReceiveMessageNotify(ECMessageNotify ecMessageNotify) {

    }

    @Override
    public void OnReceiveGroupNoticeMessage(ECGroupNoticeMessage ecGroupNoticeMessage) {

    }

    @Override
    public void onOfflineMessageCount(int i) {

    }

    @Override
    public int onGetOfflineMessage() {
        return 0;
    }

    @Override
    public void onReceiveOfflineMessage(List<ECMessage> list) {

    }

    @Override
    public void onReceiveOfflineMessageCompletion() {

    }

    @Override
    public void onServicePersonVersion(int i) {

    }

    @Override
    public void onReceiveDeskMessage(ECMessage ecMessage) {

    }

    /**
     * @param s
     * @param i
     * @deprecated
     */
    @Override
    public void onSoftVersion(String s, int i) {

    }
}
