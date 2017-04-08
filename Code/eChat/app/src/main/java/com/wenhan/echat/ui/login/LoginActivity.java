package com.wenhan.echat.ui.login;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wenhan.echat.R;
import com.wenhan.echat.ui.BaseActivity;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class LoginActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        setListener();
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
        fragmentManager = getFragmentManager();
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

}
