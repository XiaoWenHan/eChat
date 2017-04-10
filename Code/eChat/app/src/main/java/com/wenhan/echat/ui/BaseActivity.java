package com.wenhan.echat.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wenhan.echat.R;
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

    public static UIHandler uiHandler;

    public static final int MSG_INIT_STATUS = 0x01;
    public static final int MSG_INIT_STATUS_COMPLETE = 0x02;
    public static final int MSG_INIT_STATUS_FAILED = 0x03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            }
        }
    }

}
