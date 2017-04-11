package com.wenhan.echat.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenhan.echat.R;
import com.wenhan.echat.ui.BaseFragment;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class SettingsFragment extends BaseFragment {

    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_setting, container, false);
        return contentView;
    }

}
