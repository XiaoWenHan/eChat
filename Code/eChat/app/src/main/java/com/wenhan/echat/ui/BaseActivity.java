package com.wenhan.echat.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wenhan.echat.util.rl.RLConnectionUtil;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class BaseActivity extends AppCompatActivity implements RLConnectionUtil.RLConnectionCallBack {

    private final String TAG = "BaseActivity";

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
        RLConnectionUtil.getInstance(BaseActivity.this).init(this);
    }

    @Override
    public void onInitComplete() {
        Log.i(TAG, " 容联SDK服务初始化正常");
    }

    @Override
    public void onInitFailed() {
        Log.i(TAG, " 容联SDK服务初始化失败");
    }
}
