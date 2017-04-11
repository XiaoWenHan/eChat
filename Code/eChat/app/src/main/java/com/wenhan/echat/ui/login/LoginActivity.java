package com.wenhan.echat.ui.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.wenhan.echat.R;
import com.wenhan.echat.ui.BaseActivity;
import com.wenhan.echat.util.rl.RLConnectionUtil;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class LoginActivity extends BaseActivity {

    private final String TAG = "LoginActivity";

    private FragmentManager fragmentManager;
    private LoginFragment loginFragment;

    public static UIHandler uiHandler;
    private RLConnectionUtil rlConnectionUtil;

    public static final int MSG_CONNECT_STATUS = 0x01;
    public static final int MSG_CONNECT_STATUS_COMPLETE = 0x02;
    public static final int MSG_CONNECT_STATUS_FAILED = 0x03;
    public static final int MSG_CONNECT_STATUS_FAILED_KICKED_OFF = 0x04;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getBoolean(SAVED_DATA_LOGIN_STATUS)) {
            jumpToMain();
            finish();
            return;
        }
        setContentView(R.layout.activity_login);
        findView();
        setListener();
        init();
    }

    private void init() {
        uiHandler = new UIHandler();
        rlConnectionUtil = RLConnectionUtil.getInstance(LoginActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initFragment();
    }

    private void findView() {

    }

    private void setListener() {

    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        changeTuLoginFragment();
    }

    private void changeTuLoginFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
            transaction.add(R.id.activity_login_fragment_container_fl, loginFragment);
        }
        transaction.show(loginFragment);
        transaction.commit();
    }

    /**
     * 登录
     *
     * @param userNameStr
     */
    public void pendingLogin(String userNameStr) {
        showProgressDialog(getResources().getString(R.string.activity_login_login_doing_tip), null);
        rlConnectionUtil.login(userNameStr);
    }

    public class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_CONNECT_STATUS:
                    dismissProgressDialog();
                    if (msg.arg1 == MSG_CONNECT_STATUS_COMPLETE) {
                        Log.i(TAG, "登陆成功");
                        showToast(R.string.activity_base_connect_complete);
                        loginFragment.loginComplete();
                        jumpToMain();
                        finish();
                    }
                    if (msg.arg1 == MSG_CONNECT_STATUS_FAILED) {
                        Log.i(TAG, "登陆失败");
                        showToast(R.string.activity_base_connect_failed);
                        loginFragment.loginFailed();
                    }
                    if (msg.arg1 == MSG_CONNECT_STATUS_FAILED_KICKED_OFF) {
                        Log.i(TAG, "登陆失败，异地登录");
                        loginFragment.loginFailed();
                    }
                    break;
            }
        }
    }

}
