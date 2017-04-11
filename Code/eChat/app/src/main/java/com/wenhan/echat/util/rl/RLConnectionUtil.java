package com.wenhan.echat.util.rl;

import android.content.Context;

import com.wenhan.echat.constants.AppConfigConsts;
import com.wenhan.echat.util.sharedprefs.Constants;
import com.yuntongxun.ecsdk.ECDevice;
import com.yuntongxun.ecsdk.ECInitParams;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class RLConnectionUtil {

    private Context context;

    private static RLConnectionUtil instance;

    private ECInitParams ecInitParams;

    public static RLConnectionUtil getInstance(Context context) {
        if (instance == null) {
            instance = new RLConnectionUtil(context);
        }
        return instance;
    }

    private RLConnectionUtil(Context context) {
        this.context = context;
    }

    /**
     * 初始化容联SDK服务
     */
    public void init(final RLConnectionCallBack rlConnectionCallBack) {
        if (!ECDevice.isInitialized()) {
            ECDevice.initial(context, new ECDevice.InitListener() {
                @Override
                public void onInitialized() {
                    rlConnectionCallBack.onInitComplete();
                }

                @Override
                public void onError(Exception e) {
                    rlConnectionCallBack.onInitFailed();
                }
            });
        }
    }

    /**
     * 登录
     *
     * @param username
     */
    public void login(String username) {
        ecInitParams = ECInitParams.createParams();
        ecInitParams.setUserid(username);
        ecInitParams.setAppKey(AppConfigConsts.RL_APP_ID);
        ecInitParams.setToken(AppConfigConsts.RL_APP_TOKEN);
        ecInitParams.setAuthType(ECInitParams.LoginAuthType.NORMAL_AUTH);
        ecInitParams.setMode(ECInitParams.LoginMode.FORCE_LOGIN);
        ECDevice.setOnChatReceiveListener(RLConnectionHelper.getInstance(context));
        ECDevice.setOnDeviceConnectListener(RLConnectionHelper.getInstance(context));
        ECDevice.resetServer(context);
        ECDevice.login(ecInitParams);
    }

    public interface RLConnectionCallBack {
        void onInitComplete();

        void onInitFailed();
    }


}
