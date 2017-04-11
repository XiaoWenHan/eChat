package com.wenhan.echat.util.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：萧文翰
 * 如需商用，请联系作者，谢谢！
 * 联系方式：wh1990xiao2005@hotmail.com
 */

public class SharedPrefUtil {

    private static SharedPrefUtil instance;

    private Context context;

    private SharedPreferences sharedPreferences;

    public static SharedPrefUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefUtil(context);
        }
        return instance;
    }

    public SharedPrefUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(Constants.SHARE_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveRememberMeStatus(boolean isRemember) {
        sharedPreferences.edit().putBoolean(Constants.LOGIN_REMEMBER_ME, isRemember).commit();
    }

    public boolean getRememberMeStatus() {
        return sharedPreferences.getBoolean(Constants.LOGIN_REMEMBER_ME, false);
    }

    public void saveLoginUserName(String userName) {
        sharedPreferences.edit().putString(Constants.LOGIN_USER_NAME, userName).commit();
    }

    public String getLoginUserName() {
        return sharedPreferences.getString(Constants.LOGIN_USER_NAME, "");
    }

}
