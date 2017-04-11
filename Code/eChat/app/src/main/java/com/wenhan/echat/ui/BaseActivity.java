package com.wenhan.echat.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wenhan.echat.R;
import com.wenhan.echat.eChatApplication;
import com.wenhan.echat.ui.main.MainActivity;
import com.wenhan.echat.util.rl.RLConnectionHelper;
import com.wenhan.echat.util.rl.RLConnectionUtil;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class BaseActivity extends AppCompatActivity {

    private final String TAG = "BaseActivity";

    private Toast toast;

    private ProgressDialog progressDialog;

    private RLConnectionHelper rlConnectionHelper;

    private eChatApplication application;
    protected final String SAVED_DATA_LOGIN_STATUS = "login_status";

    public static UIHandler uiHandler;

    public static final int MSG_INIT_STATUS = 0x01;
    public static final int MSG_INIT_STATUS_COMPLETE = 0x02;
    public static final int MSG_INIT_STATUS_FAILED = 0x03;

    public static final int MSG_CONNECT_STATUS = 0x04;
    public static final int MSG_CONNECT_STATUS_COMPLETE = 0x05;
    public static final int MSG_CONNECT_STATUS_FAILED = 0x06;
    public static final int MSG_CONNECT_STATUS_FAILED_KICKED_OFF = 0x07;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        application = (eChatApplication) getApplication();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initRlSDK();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initRlSDK() {
        uiHandler = new UIHandler();
        rlConnectionHelper = RLConnectionHelper.getInstance(BaseActivity.this);
        RLConnectionUtil.getInstance(BaseActivity.this).init(rlConnectionHelper);
    }

    public void showToast(String toastStr) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(BaseActivity.this, toastStr, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showToast(int toastStrRes) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(BaseActivity.this, getResources().getString(toastStrRes), Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showProgressDialog(String contentStr, String titleStr) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = ProgressDialog.show(BaseActivity.this, titleStr, contentStr);
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(SAVED_DATA_LOGIN_STATUS, application.isLogin);
        super.onSaveInstanceState(outState);
    }

    protected void jumpToMain() {
        application.isLogin = true;
        startActivity(new Intent(BaseActivity.this, MainActivity.class));
    }

    public class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_INIT_STATUS:
                    if (msg.arg1 == MSG_INIT_STATUS_COMPLETE) {
                        showToast(R.string.activity_base_init_complete);
                    }
                    if (msg.arg1 == MSG_INIT_STATUS_FAILED) {
                        showToast(R.string.activity_base_init_failed);
                    }
                    break;
                case MSG_CONNECT_STATUS:
                    if (msg.arg1 == MSG_CONNECT_STATUS_COMPLETE) {

                    }
                    if (msg.arg1 == MSG_CONNECT_STATUS_FAILED_KICKED_OFF) {
                        showToast(R.string.activity_base_connect_failed_kicked_off);
                    }
                    if (msg.arg1 == MSG_CONNECT_STATUS_FAILED) {

                    }

            }
        }
    }

}
