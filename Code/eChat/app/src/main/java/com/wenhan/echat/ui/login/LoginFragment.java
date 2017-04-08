package com.wenhan.echat.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.wenhan.echat.R;
import com.wenhan.echat.ui.BaseFragment;
import com.wenhan.echat.util.sharedprefs.SharedPrefUtil;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class LoginFragment extends BaseFragment {

    private View contentView;
    private EditText usernameInputEt;
    private CheckBox rememberMeCb;
    private Button loginBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_login, container, false);
        findView();
        setListener();
        init();
        return contentView;
    }

    private void findView() {
        usernameInputEt = (EditText) contentView.findViewById(R.id.fragment_login_username_et);
        rememberMeCb = (CheckBox) contentView.findViewById(R.id.fragment_login_remember_me_cb);
        loginBtn = (Button) contentView.findViewById(R.id.fragment_login_login_btn);
    }

    private void setListener() {
        rememberMeCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPrefUtil.getInstance(getActivity()).saveRememberMeStatus(isChecked);
            }
        });
    }

    private void init() {
        rememberMeCb.setChecked(SharedPrefUtil.getInstance(getActivity()).getRememberMeStatus());
    }

}
