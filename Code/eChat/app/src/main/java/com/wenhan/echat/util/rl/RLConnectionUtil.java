package com.wenhan.echat.util.rl;

import android.content.Context;

import com.yuntongxun.ecsdk.ECDevice;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class RLConnectionUtil {

    private Context context;

    private static RLConnectionUtil instance;

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

    public interface RLConnectionCallBack {
        void onInitComplete();

        void onInitFailed();
    }


}
