package com.wenhan.echat.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;

import com.wenhan.echat.R;
import com.wenhan.echat.ui.BaseActivity;

import java.util.ArrayList;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class MainActivity extends BaseActivity {

    private final String TAG = "MainActivity";

    private TabLayout botTl;
    private ViewPager contentVp;

    private ArrayList<Fragment> contentFragments;
    private ArrayList<Integer> tabIcon;

    private RecentFragment recentFragment;
    private ContactFragment contactFragment;
    private SettingsFragment settingsFragment;

    private MainFragmentAdapter mainFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListener();
        init();
    }

    private void findView() {
        botTl = (TabLayout) findViewById(R.id.activity_main_bot_tab_tl);
        contentVp = (ViewPager) findViewById(R.id.activity_main_content_vp);
    }

    private void setListener() {
        contentVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "页卡改变，当前所选：" + position);
                pageSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void init() {
        //初始化Fragments
        recentFragment = new RecentFragment();
        contactFragment = new ContactFragment();
        settingsFragment = new SettingsFragment();
        contentFragments = new ArrayList<>();
        contentFragments.add(recentFragment);
        contentFragments.add(contactFragment);
        contentFragments.add(settingsFragment);
        tabIcon = new ArrayList<>();
        tabIcon.add(R.drawable.activity_main_bot_tab_recent);
        tabIcon.add(R.drawable.activity_main_bot_tab_contacts);
        tabIcon.add(R.drawable.activity_main_bot_tab_settings);
        mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), MainActivity.this, contentFragments, tabIcon);
        contentVp.setAdapter(mainFragmentAdapter);
        botTl.setupWithViewPager(contentVp);
        botTl.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < botTl.getTabCount(); i++) {
            TabLayout.Tab tab = botTl.getTabAt(i);
            tab.setCustomView(mainFragmentAdapter.getTabView(i));
        }
        pageSelect(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

        }
        return super.onKeyDown(keyCode, event);
    }

    private void pageSelect(int index) {
        switch (index) {
            case 0:
                getSupportActionBar().setTitle(R.string.activity_main_bot_tab_recent);
                break;
            case 1:
                getSupportActionBar().setTitle(R.string.activity_main_bot_tab_contacts);
                break;
            case 2:
                getSupportActionBar().setTitle(R.string.activity_main_bot_tab_settings);
                break;
        }
    }

}
