package com.wenhan.echat.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wenhan.echat.R;

import java.util.ArrayList;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private final int PAGE_COUNT = 3;

    private Context context;

    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> tabIcon;

    public MainFragmentAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments,ArrayList<Integer> tabIcon) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.tabIcon = tabIcon;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity_main_bottom_tab, null);
        ImageView img = (ImageView) view.findViewById(R.id.item_activity_main_bottom_tab_iv);
        img.setImageResource(tabIcon.get(position));
        return view;
    }

}
